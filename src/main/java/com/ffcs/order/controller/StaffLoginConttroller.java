package com.ffcs.order.controller;


import com.ffcs.order.service.StaffLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "后台登陆")
@RestController
@RequestMapping(path ="/eleme/bg")
public class StaffLoginConttroller {

    @Autowired
    StaffLoginService staffLoginService;

    @ApiOperation(value = "员工登陆接口", notes = "")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String staffId,
                        @RequestParam String password) {
        return staffLoginService.login(staffId,password);
    }




}
