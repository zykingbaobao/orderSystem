package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:取消订单类
 */
@Data
public class Cancelorderapplication {
    private int orderId;
    private String userId;
    private String reason;
    private String status;
    private String feedback;
    private String createTime;
    private String updateTime;

}
