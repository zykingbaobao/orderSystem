package com.ffcs.order.controller;


import com.ffcs.order.entity.user;
import com.ffcs.order.mapper.LoginMapper;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginConttroller {
    @Autowired
    private LoginMapper login;
    @Autowired
    private JWTtool jwTtool;
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userId,
                        @RequestParam String password) {

        user us=login.select(userId,password);
        System.out.println(us.getUserName());
        if(us.getUserName()!=null){

            return jwTtool.getToken(userId);
        }
        return "0";
    }




}
