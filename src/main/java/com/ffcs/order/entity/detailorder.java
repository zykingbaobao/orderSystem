package com.ffcs.order.entity;

import lombok.Data;

@Data
public class detailorder {

    private String orderNumber;
    private String commodityId;
    private int orderAmount;
    private float commodityPrice;
    private String createTime;
    private String updateTime;

}
