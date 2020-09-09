package com.ffcs.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Order;
import com.ffcs.order.mapper.OrderMapper;
import com.ffcs.order.service.OrderService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//
//    @ApiOperation(value = "审核退订订单接口", notes = "")
//    @RequestMapping(path = "/examine", method = RequestMethod.POST)
//    public String queryCancelList(@RequestParam int orderId,@RequestParam String feedback,@RequestParam int status) {
//        return orderService.updateCancelOrder(orderId,feedback,status);
//    }

    @ApiOperation(value = "订单状态更新接口", notes = "")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Order order) {
        return orderService.updateOrder(order.getOrderId(),order.getStatus());
    }
    @ApiOperation(value = "取消订单状态更新接口", notes = "")
    @RequestMapping(path = "/updateCancel", method = RequestMethod.POST)
    public String update(@RequestBody Cancelorderapplication cancelorderapplication) {
        return orderService.updateCancelOrder(cancelorderapplication.getOrderId(),cancelorderapplication.getFeedback(),cancelorderapplication.getStatus());
    }


    /**
     * 客户端返回订单
     * @return
     */
    @ResponseBody
    @PostMapping("eleme/list")
    public String getOrderList(@RequestBody Order order){
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> data = new HashMap<String,Object>();
        Gson gson = new Gson();
        List<Order> list1 = null;

        if(order.getStatus()==4){
            list1 =  orderService.getOrderByUserId(order);
        }
        if(order.getStatus()!=4){
            if(order.getStatus()==2){
                list1 = orderService.getOrderByStatus(order);
                order.setStatus(3);
                List<Order> list2 = orderService.getOrderByStatus(order);
                for (Order or :list2){
                    list1.add(or);
                }
            }else{
                list1 = orderService.getOrderByStatus(order);
            }

        }

        if(list1!=null){
            data.put("list",list1);
            map.put("data",data);
            map.put("code",0);
            map.put("message","成功");
        }else{
            map.put("code",-1);
            map.put("message","失败");
        }

        return gson.toJson(map);
    }
}
