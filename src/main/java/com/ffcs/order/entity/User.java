package com.ffcs.order.entity;

import lombok.Data;

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
    private String createTime;
    private String updateTime;
}
