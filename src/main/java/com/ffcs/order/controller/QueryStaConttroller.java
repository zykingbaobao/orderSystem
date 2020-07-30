package com.ffcs.order.controller;


import com.ffcs.order.entity.orderStatistics;
import com.ffcs.order.entity.statistics;
import com.ffcs.order.entity.user;
import com.ffcs.order.mapper.QueryStaMapper;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryStaConttroller {
    @Autowired
    private QueryStaMapper qsm;
    @Autowired
    private JWTtool jwTtool;
    @RequestMapping(path = "/QueryStaById", method = RequestMethod.POST)
    public String QueryStaById(@RequestParam String commodityId) {

        orderStatistics us=qsm.selectById(commodityId);

        return "us";
    }

    @RequestMapping(path = "/QuerySta", method = RequestMethod.POST)
    public String QuerySta(@RequestParam String updateTime) {

        statistics us=qsm.selectSta(updateTime);

        return "us";
    }




}
