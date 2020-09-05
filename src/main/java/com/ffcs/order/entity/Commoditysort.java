package com.ffcs.order.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 张勇
 * @Description:商品类别类
 */
@Data
public class Commoditysort {
    private int sortId;
    private String sortName;
    private Date createTime;
    private Date updateTime;


}
