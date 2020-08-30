package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:员工类
 */
@Data
public class Staff {
    private int  staffId;
    private String staffName;
    private String permissionId;
    private String password;
    private String createTime;
    private String updateTime;
}
