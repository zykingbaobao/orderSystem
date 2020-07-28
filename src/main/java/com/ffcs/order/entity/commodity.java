package com.ffcs.order.entity;

import lombok.Data;

@Data
public class commodity {
    private  String commodityId;
    private  String commodityName;
    private  String describe;
    private  float commodityMoney;
    private  String commodityImageUrl;
    private  int sortId;
    private  String materials;
    private  String createTime;
    private  String updateTime;

}
