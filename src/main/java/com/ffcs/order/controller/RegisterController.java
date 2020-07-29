package com.ffcs.order.controller;

import com.ffcs.order.entity.user;
import com.ffcs.order.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {
    @Autowired
    private RegisterMapper re;
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(required=false) String userId,
                           @RequestParam(required=false) String userName,
                           @RequestParam(required=false) String address,
                           @RequestParam(required=false) String password1,
                           @RequestParam(required=false) String password2) {
        user ss=new user();
        ss.setUserId(userId);
        ss.setUserName(userName);
        if(password1==password2)
        {
            ss.setPassword(password1);
        }
        ss.setAddress(address);
        re.insert(ss);

           return "index";
    }
}
