package com.ffcs.order.entity;

import lombok.Data;

import java.util.Date;
@Data
public class order {
    private String orderId;
    private String userId;
    private String address;
    private float orderMoney;
    private int status;
    private Date orderTime;
    private String createTime;
    private String updateTime;

}
