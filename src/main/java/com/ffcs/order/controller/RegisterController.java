package com.ffcs.order.controller;

import com.ffcs.order.entity.User;
import com.ffcs.order.mapper.RegisterMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = "注册")
@RestController
public class RegisterController {
    @Autowired
    private RegisterMapper re;
    @ApiOperation(value = "注册接口", notes = "")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(required=false) String userId,
                           @RequestParam(required=false) String userName,
                           @RequestParam(required=false) String address,
                           @RequestParam(required=false) String password1,
                           @RequestParam(required=false) String password2) {
        User ss=new User();
        ss.setUserId(userId);
        ss.setUserName(userName);
        if(password1.equals(password2))
        {
            ss.setPassword(password1);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt=simpleDateFormat.format(date);
        ss.setCreateTime(dt);
        ss.setUpdateTime(dt);
        ss.setAddress(address);
        re.insert(ss);

           return "1";
    }
}
