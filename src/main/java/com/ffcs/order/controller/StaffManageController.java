package com.ffcs.order.controller;

import com.ffcs.order.service.StaffManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "后台员工注册")
@RestController
@RequestMapping(path ="/staff")
public class StaffManageController {
    @Autowired
    StaffManageService staffManageService;
    @ApiOperation(value = "员工注册接口", notes = "")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register( @RequestParam String staffName,
                            @RequestParam String permissionId,
                            @RequestParam String password) {

           return staffManageService.regisiter(staffName,permissionId,password);
    }
}
