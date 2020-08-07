package com.ffcs.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.StaffLoginMapper;
import com.ffcs.order.tools.JWTtool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "后台登陆")
@RestController
public class StaffLoginConttroller {
    @Autowired
    private StaffLoginMapper login;
    @Autowired
    private JWTtool jwTtool;
    @ApiOperation(value = "员工登陆接口", notes = "")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String staffId,
                        @RequestParam String password) {

        Staff staff=login.select(staffId,password);
        JSONObject json=new JSONObject();
        if(staff.getPermissionId()!=null){

            String gson= json.toJSONString(jwTtool.getToken(staffId));
            return gson;
        }
        return "0";
    }




}
