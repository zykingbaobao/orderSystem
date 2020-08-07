package com.ffcs.order.controller;

import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.StaffRegisterMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "后台员工注册")
@RestController
public class StaffRegisterController {
    @Autowired
    private StaffRegisterMapper re;
    @ApiOperation(value = "员工注册接口", notes = "")
    @RequestMapping(path = "/staffRegister", method = RequestMethod.POST)
    public int  register(Staff staff) {

           return re.insert(staff);
    }
}
