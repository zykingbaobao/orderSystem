package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:订单统计信息类
 */
@Data
public class OrderStatistics {
    private String commodityId;
    private int orderNumber;
    private float orderAmount;
    private String createTime;
    private String updateTime;
}
