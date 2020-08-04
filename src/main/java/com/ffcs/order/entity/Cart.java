package com.ffcs.order.entity;

import lombok.Data;

@Data
public class Cart {
    private String userId;
    private String commodityId;
    private int amount;
    private String createTime;
    private String updateTime;

}
