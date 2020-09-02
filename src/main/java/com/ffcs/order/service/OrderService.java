package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Detailorder;
import com.ffcs.order.entity.Order;
import com.ffcs.order.mapper.OrderMapper;
import com.ffcs.order.pojo.OrderPojo;
import com.ffcs.order.pojo.ReInfoPojo;
import com.ffcs.order.pojo.ReInfoPojo2;
import com.ffcs.order.pojo.ReInfoPojo3;
import com.ffcs.order.tools.JWTtool;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class OrderService {
    @Autowired
    private JWTtool jwTtool;
    @Resource
    private OrderMapper mapper;
    JSONObject json=new JSONObject();
    public String queryOrderList(){
        List<Order>list= mapper.queryOrderList();
        List<Detailorder> list2=null;
        ReInfoPojo3 reInfoPojo3=new ReInfoPojo3();
        OrderPojo orderPojo=null;
        List<OrderPojo> data=null;
        Map<String,String> map=null;
        List<Map<String,String>> list3=null;
        if(list.size()!=0){
            reInfoPojo3.setCode("0");
            reInfoPojo3.setMessage("查询成功！");
            data=new ArrayList<OrderPojo>();
            for (int i=0;i<list.size();i++){
                orderPojo=new OrderPojo();

                list2=new ArrayList<Detailorder>();
                list2=mapper.queryOrderDetail(list.get(i).getOrderId());
                orderPojo.setCreateTime(list.get(i).getCreateTime());
                orderPojo.setOrderId(String.valueOf(list.get(i).getOrderId()));
                orderPojo.setStatus(String.valueOf(list.get(i).getStatus()));
               if(mapper.queryCancelOrderById(list.get(i).getOrderId()).getReason()!=null){
                   Cancelorderapplication cancelorderapplication=mapper.queryCancelOrderById(list.get(i).getOrderId());
                   orderPojo.setFeedback(cancelorderapplication.getFeedback());
               }else{
                   orderPojo.setFeedback("");
               }
            list3=new ArrayList<Map<String,String>>();

                float amount=0;
                int num=0;
                for (int j=0;j<list2.size();j++){
                    amount=amount+(list2.get(j).getOrderAmount()*list2.get(j).getCommodityPrice());
                    num=num+list2.get(j).getOrderAmount();
                    map=new HashMap<String, String>();
                    map.put("commoditytId",String.valueOf(list2.get(j).getCommodityId()));
                    map.put("commodityMoney",String.valueOf(list2.get(j).getCommodityPrice()));
                    map.put("number",String.valueOf(list2.get(j).getOrderAmount()));
                    map.put("commoditytName",mapper.queryCommodityNameById(list2.get(j).getCommodityId()));
                    list3.add(map);

                }
                orderPojo.setCommodityList(list3);
                orderPojo.setOrderAmount(String.valueOf(amount));
                orderPojo.setOrderNumber(String.valueOf(num));
                data.add(orderPojo);

            }
            reInfoPojo3.setData(data);
            String gson= json.toJSONString(reInfoPojo3);
            return gson;
        }else {
            reInfoPojo3.setCode("-1");
            reInfoPojo3.setMessage("查询失败！");
            reInfoPojo3.setData(data);
            String gson= json.toJSONString(reInfoPojo3);
            return  gson;
        }

    }
    public String queryCancelList(){
        List<Cancelorderapplication> list=mapper.queryCancelList();
        List<Detailorder> list2=null;
        ReInfoPojo2 reInfoPojo2=new ReInfoPojo2();
        List<Map<String,String>> data=new ArrayList<Map<String,String>>();
        Map<String,String> map=null;
        if(list.size()!=0){
            reInfoPojo2.setCode("0");
            reInfoPojo2.setMessage("查询成功！");
            for (int i=0;i<list.size();i++){
                map=new HashMap<String, String>();
                list2=new ArrayList<Detailorder>();
                list2=mapper.queryOrderDetail(list.get(i).getOrderId());
               map.put("reason",list.get(i).getReason());
               map.put("feedback",list.get(i).getFeedback());
               map.put("status",list.get(i).getStatus());
               map.put("orderId",list.get(i).getUserId());
               map.put("createTime",list.get(i).getCreateTime());
               float amount=0;
               int num=0;
               for (int j=0;j<list2.size();j++){
                   amount=amount+(list2.get(j).getOrderAmount()*list2.get(j).getCommodityPrice());
                   num=num+list2.get(j).getOrderAmount();
               }
                map.put("orderAmount",String.valueOf(amount));
                map.put("orderNumber",String.valueOf(num));
                data.add(map);

            }
            reInfoPojo2.setData(data);
           String gson= json.toJSONString(reInfoPojo2);
            return gson;
        }else {
            reInfoPojo2.setCode("-1");
            reInfoPojo2.setMessage("查询失败！");
            reInfoPojo2.setData(data);
            String gson= json.toJSONString(reInfoPojo2);
            return  gson;
        }


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
