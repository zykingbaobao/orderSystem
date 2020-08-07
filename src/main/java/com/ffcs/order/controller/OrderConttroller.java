package com.ffcs.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Order;
import com.ffcs.order.mapper.OrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户订单管理")
@RestController
public class OrderConttroller {
    @Autowired
    private OrderMapper orderMapper;
    @ApiOperation(value = "查询用户订单接口", notes = "")
    @RequestMapping(path = "/queryOrderByPage", method = RequestMethod.POST)
    public String queryOrderByPage(@RequestParam String userId,
                                   @RequestParam int pageNum,
                                   @RequestParam int pageSize
                                   ) {
        List<Order> list=new ArrayList<Order>();
        pageNum=(pageNum-1)*pageSize;
        list=orderMapper.queryOrderByPage(userId,pageNum,pageSize);
        JSONObject json=new JSONObject();
        String gson= json.toJSONString(list);
            return gson;

    }
    @ApiOperation(value = "退订订单接口", notes = "")
    @RequestMapping(path = "/deleteOrderById", method = RequestMethod.POST)
    public int deleteOrderById(Cancelorderapplication cancelorderapplication
                               ) {

               orderMapper.insertCancelOrder(cancelorderapplication);
        return orderMapper.deleteOrderById(cancelorderapplication.getOrderNumber());

    }


}
