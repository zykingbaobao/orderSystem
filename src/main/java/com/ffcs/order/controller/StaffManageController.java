package com.ffcs.order.controller;


import com.ffcs.order.entity.Staff;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ffcs.order.service.*;
import javax.annotation.Resource;

@Api(tags = "后台员工注册")
@RestController
@RequestMapping(path ="/staff")

public class StaffManageController {
    @Resource
    StaffManageService staffManageService;

    @ApiOperation(value = "员工注册接口", notes = "")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register( @RequestParam String staffName,
                            @RequestParam String permissionId,
                            @RequestParam String password) {

           return staffManageService.regisiter(staffName,permissionId,password);
    }

    @ApiOperation(value = "员工更新接口", notes = "")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update( @RequestParam String staffName,
                            @RequestParam String permissionId,
                            @RequestParam String password) {

        return staffManageService.update(staffName,permissionId,password);
    }
    @ApiOperation(value = "员工查询列表接口", notes = "")
    @RequestMapping(path = "/select", method = RequestMethod.POST)
    public String select() {

        return staffManageService.select();
    }

    @ApiOperation(value = "员工登陆接口", notes = "")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Staff staff) {
        return staffManageService.login(staff.getStaffId(),staff.getPassword());
    }
    @ApiOperation(value = "员工查询单个接口", notes = "")
    @RequestMapping(path = "/selectOne", method = RequestMethod.POST)
    public String selectOne(@RequestParam String staffId) {

        return staffManageService.selectOne(Integer.valueOf(staffId));
    }
}
