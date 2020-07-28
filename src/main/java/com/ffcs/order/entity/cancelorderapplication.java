package com.ffcs.order.entity;

import lombok.Data;

@Data
public class cancelorderapplication {
    private String orderNumber;
    private String userId;
    private String reason;
    private String status;
    private String feedback;
    private String createTime;
    private String updateTime;

}
