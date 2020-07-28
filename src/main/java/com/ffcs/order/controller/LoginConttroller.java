package com.ffcs.order.controller;


import com.ffcs.order.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginConttroller {
    @Autowired
    private LoginMapper login;
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userId,
                        @RequestParam String password) {
                  login.insert(userId,password);
                  return "";

    }




}
