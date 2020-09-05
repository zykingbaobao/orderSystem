package com.ffcs.order.controller;

import com.ffcs.order.entity.User;
import com.ffcs.order.mapper.UserMapper;
import com.ffcs.order.tools.JWTtool;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 客户端用户接口
 * @author LinXin
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    JWTtool jwTtool;

    @PostMapping("eleme/registration")
    public String register(@RequestBody User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        Gson gson = new Gson();
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = userMapper.addUser(user);
        if(i==1){
            map.put("code",0);
            map.put("message","注册成功");
        }else{
            map.put("code",-1);
            map.put("message","注册失败");
        }
        return gson.toJson(map);
    }

    @ResponseBody
    @PostMapping("eleme/login")
    public String login(@RequestBody User user1) {

        //System.out.println("user1="+user1.getUserId()+","+user1.getPassword());
        Map<String,Object> map = new HashMap<String,Object>();
        Gson gson = new Gson();
        /*User user1 = new User();
        user1.setUserId(userId+"");
        user1.setPassword(password+"");*/
        User user = userMapper.isLogin(user1);
        Map<String,Object> data = new HashMap<String,Object>();
        if(user!=null){
            String token = jwTtool.getToken(user1.getUserId());
            data.put("userId",user.getUserId());
            data.put("password",user.getPassword());
            data.put("token",token);
            map.put("data",data);
            map.put("code",0);
            map.put("message","登录成功");
        }else {
            map.put("code",-1);
            map.put("message","登录失败");
        }
        return gson.toJson(map);
    }
}  