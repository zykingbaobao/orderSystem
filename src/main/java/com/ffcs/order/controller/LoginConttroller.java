package com.ffcs.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.User;
import com.ffcs.order.mapper.LoginMapper;
import com.ffcs.order.tools.JWTtool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登陆")
@RestController
public class LoginConttroller {
    @Autowired
    private LoginMapper login;
    @Autowired
    private JWTtool jwTtool;
    @ApiOperation(value = "登陆接口", notes = "")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userId,
                        @RequestParam String password) {

        User us=login.select(userId,password);
        System.out.println(us.getUserName());
        JSONObject json=new JSONObject();
        if(us.getUserName()!=null){

            String gson= json.toJSONString(jwTtool.getToken(userId));
            return gson;
        }
        return "0";
    }




}
