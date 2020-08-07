package com.ffcs.order.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 张勇
 * @Description:订单类
 */
@Data
public class Order {
    private String orderId;
    private String userId;
    private String address;
    private float orderMoney;
    private int status;
    private Date orderTime;
    private String createTime;
    private String updateTime;

}
