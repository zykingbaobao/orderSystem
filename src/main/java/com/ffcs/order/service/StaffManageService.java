package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.StaffManageMapper;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StaffManageService {
    @Autowired
    private JWTtool jwTtool;
   @Resource
    private StaffManageMapper re;

    public String regisiter( String staffName,
                             String permissionId,
                             String password){

        Staff staff=new Staff();
        JSONObject json=new JSONObject();
        staff.setStaffName(staffName);
        staff.setPermissionId(permissionId);
        staff.setPassword(password);
        if(re.insert(staff)>=1){

            Map<String,String> data=new HashMap<>();
            data.put("code","1");
            data.put("message","注册成功！");
           String gson= json.toJSONString( data);
            return gson;
        }else {
            Map<String,String> data=new HashMap<>();
            data.put("code","0");
            data.put("message","注册失败！");
            String gson= json.toJSONString( data);
            return gson;
        }

    }

}
