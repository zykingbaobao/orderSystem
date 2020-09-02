package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Order;
import com.ffcs.order.mapper.OrderMapper;
import com.ffcs.order.pojo.ReInfoPojo;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    @Autowired
    private JWTtool jwTtool;
    @Resource
    private OrderMapper mapper;
    JSONObject json=new JSONObject();
    public String queryOrderList(){
        List<Order>list= mapper.queryOrderList();
        for (int i=0;i<list.size();i++){



        }
        return "";
    }
    public String queryCancelList(){
        mapper.queryCancelList();

        return "";
    }







    public String updateOrder(int orderId,int status){
        ReInfoPojo reInfoPojo=new ReInfoPojo();
        int i= mapper.updateOrder(orderId,status);
        Map<String,String> data=new HashMap<String,String>();
        if(i>=1){
            reInfoPojo.setMessage("更新成功！");
            reInfoPojo.setCode("0");
            reInfoPojo.setData(data);
            return json.toJSONString(reInfoPojo);
        }else {
            reInfoPojo.setMessage("更新失败！");
            reInfoPojo.setCode("-1");
            reInfoPojo.setData(data);
            return json.toJSONString(reInfoPojo);
        }
    }
    public String updateCancelOrder(int orderId,String feedback,int status){
        ReInfoPojo reInfoPojo=new ReInfoPojo();
        int i=mapper.updateCancelOrder(orderId,feedback,status);
        Map<String,String> data=new HashMap<String,String>();
         if(i>=1){
             reInfoPojo.setMessage("更新成功！");
             reInfoPojo.setCode("0");
             reInfoPojo.setData(data);
             return json.toJSONString(reInfoPojo);
         }else {
             reInfoPojo.setMessage("更新失败！");
             reInfoPojo.setCode("-1");
             reInfoPojo.setData(data);
             return json.toJSONString(reInfoPojo);

         }

    }

}
