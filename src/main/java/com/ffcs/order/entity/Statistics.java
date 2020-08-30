package com.ffcs.order.entity;

import lombok.Data;
/**
 * @author 张勇
 * @Description:统计信息类
 */
@Data
public class Statistics {

    private int orderNumber;
    private float orderAmount;
    private String date;
    private String createTime;
    private String updateTime;


}
