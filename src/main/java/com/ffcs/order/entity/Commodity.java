package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:商品类
 */
@Data
public class Commodity {
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
