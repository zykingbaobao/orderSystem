package com.ffcs.order.entity;

import lombok.Data;

@Data
public class Staff {
    private String staffId;
    private String staffName;
    private String permissionId;
    private String password;
    private String createTime;
    private String updateTime;
}
