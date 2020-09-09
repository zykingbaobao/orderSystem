package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:购物车类
 */
@Data
public class Cart {
    private int id;
    private String userId;
    private int amount;
    private  int commodityId;
    private  String commodityName;
    private  String describe;
    private  float commodityMoney;
    private  String commodityImageUrl;
    private  int sortId;
    private  String materials;
    private  String createTime;
    private  String updateTime;
}
