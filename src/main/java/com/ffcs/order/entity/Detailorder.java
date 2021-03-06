package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:订单细节类
 */
@Data
public class Detailorder {

    private int  orderId;
    private int  commodityId;
    private int orderAmount;
    private float commodityPrice;
    private String createTime;
    private String updateTime;

}
