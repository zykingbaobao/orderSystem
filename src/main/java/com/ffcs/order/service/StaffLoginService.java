package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.StaffLoginMapper;
import com.ffcs.order.pojo.ReInfoPojo;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StaffLoginService {
    @Autowired
    private JWTtool jwTtool;
    @Resource
    private StaffLoginMapper login;

    public String login( String staffId,
                        String password ){

        Staff staff=login.select(staffId,password);
        JSONObject json=new JSONObject();
        if(staff.getPermissionId()!=null){

            String gson= json.toJSONString(jwTtool.getToken(staffId));
            ReInfoPojo reInfoPojo =new ReInfoPojo();
            reInfoPojo.setCode("1");
            reInfoPojo.setMessage("登陆成功！");
            Map<String,String> data=new HashMap<>();
            data.put("token",gson);
            data.put("staffId",staff.getStaffId().toString());
            data.put("staffName",staff.getStaffName());
            data.put("permissionId",staff.getPermissionId().toString());
            data.put("password",staff.getPassword());
            reInfoPojo.setData(data);
            gson= json.toJSONString(reInfoPojo);
            return gson;
        }else {

            String gson= json.toJSONString(jwTtool.getToken(staffId));
            ReInfoPojo reInfoPojo =new ReInfoPojo();
            reInfoPojo.setCode("0");
            reInfoPojo.setMessage("登陆失败！");
            Map<String,String> data=new HashMap<>();
            reInfoPojo.setData(data);
            gson= json.toJSONString(reInfoPojo);
            return gson;
        }

    }

}
