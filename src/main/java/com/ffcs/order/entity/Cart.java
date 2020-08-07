package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:购物车类
 */
@Data
public class Cart {
    private String userId;
    private String commodityId;
    private int amount;
    private String createTime;
    private String updateTime;

}
