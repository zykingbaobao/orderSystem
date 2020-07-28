package com.ffcs.order.entity;

import lombok.Data;

@Data
public class orderstatistics {
    private String commodityId;
    private int orderNumber;
    private float orderAmount;
    private String createTime;
    private String updateTime;
}
