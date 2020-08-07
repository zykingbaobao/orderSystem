package com.ffcs.order.entity;

import lombok.Data;

/**
 * @author 张勇
 * @Description:权限信息类
 */
@Data
public class Permission {
    private String permissionId;
    private String permissionName;
    private String havePermission;
    private String createTime;
    private String updateTime;


}
