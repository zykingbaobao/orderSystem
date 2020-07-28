package com.ffcs.order.entity;

import lombok.Data;

@Data
public class statistics {
    private int orderNumber;
    private float orderAmount;
    private String date;
    private String createTime;
    private String updateTime;


}
