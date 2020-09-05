package com.ffcs.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Order;
import com.ffcs.order.mapper.OrderMapper;
import com.ffcs.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户订单管理")
@RestController
@RequestMapping(path ="/ident")
public class OrderConttroller {

    @Resource
    OrderService orderService;
//    @ApiOperation(value = "查询用户订单接口", notes = "")
//    @RequestMapping(path = "/queryOrderByPage", method = RequestMethod.POST)
//    public String queryOrderByPage(@RequestParam String userId,
//                                   @RequestParam int pageNum,
//                                   @RequestParam int pageSize
//                                   ) {
//        List<Order> list=new ArrayList<Order>();
//        pageNum=(pageNum-1)*pageSize;
//        list=orderService.queryOrderByPage(userId,pageNum,pageSize);
//        JSONObject json=new JSONObject();
//        String gson= json.toJSONString(list);
//            return gson;
//
//    }
//    @ApiOperation(value = "退订订单接口", notes = "")
//    @RequestMapping(path = "/deleteOrderById", method = RequestMethod.POST)
//    public int deleteOrderById(Cancelorderapplication cancelorderapplication
//                               ) {
//
//               orderService.insertCancelOrder(cancelorderapplication);
//        return orderService.deleteOrderById(cancelorderapplication.getOrderNumber());
//
//    }
    @ApiOperation(value = "查询全部订单接口", notes = "")
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public String queryOrderList() {
        return orderService.queryOrderList();
    }

    @ApiOperation(value = "查询全部退订订单接口", notes = "")
    @RequestMapping(path = "/cancelList", method = RequestMethod.POST)
    public String queryCancelList() {
        return orderService.queryCancelList();
    }

    @ApiOperation(value = "审核退订订单接口", notes = "")
    @RequestMapping(path = "/examine", method = RequestMethod.POST)
    public String queryCancelList(@RequestParam int orderId,@RequestParam String feedback,@RequestParam int status) {
        return orderService.updateCancelOrder(orderId,feedback,status);
    }

    @ApiOperation(value = "订单状态更新接口", notes = "")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(@RequestParam int orderId,@RequestParam int status) {
        return orderService.updateOrder(orderId,status);
    }

}
