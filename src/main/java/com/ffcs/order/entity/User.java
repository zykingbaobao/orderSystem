package com.ffcs.order.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 张勇
 * @Description:用户类
 */
@Data
public class User {
    private String userId;
    private String userName;
    private String address;
    private String password;
    private Date createTime;
    private Date updateTime;
}
