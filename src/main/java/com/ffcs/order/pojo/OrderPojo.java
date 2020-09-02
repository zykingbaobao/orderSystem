package com.ffcs.order.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class OrderPojo {

    String feedback;
    String status;
    String orderId;
    String createTime;
    List<Map<String,String>> commodityList;
    String orderAmount;
    String orderNumber;
}
