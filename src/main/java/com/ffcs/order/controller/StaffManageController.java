package com.ffcs.order.controller;


import com.ffcs.order.entity.Staff;
import com.ffcs.order.pojo.Page;
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
    @Autowired
    StaffManageService staffManageService;

    @ApiOperation(value = "员工注册接口", notes = "")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register( @RequestBody Staff staff) {

           return staffManageService.regisiter(staff.getStaffName(),staff.getPermissionId(),staff.getPassword());
    }

    @ApiOperation(value = "员工更新接口", notes = "")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Staff staff) {

        return staffManageService.update(staff.getStaffId(),staff.getPermissionId(),staff.getPassword());
    }
    @ApiOperation(value = "员工查询列表接口", notes = "")
    @RequestMapping(path = "/select", method = RequestMethod.POST)
    public String select(@RequestBody Page page) {

        return staffManageService.select(page);
    }

    @ApiOperation(value = "员工登陆接口", notes = "")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Staff staff) {
        return staffManageService.login(staff.getStaffId(),staff.getPassword());
    }
    @ApiOperation(value = "员工查询单个接口", notes = "")
    @RequestMapping(path = "/selectOne", method = RequestMethod.POST)
    public String selectOne(@RequestBody Staff staff) {

        return staffManageService.selectOne(staff.getStaffId());
    }

    @ApiOperation(value = "员工登陆接口", notes = "")
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Staff staff) {
        return staffManageService.delete(staff.getStaffId());
    }
}
