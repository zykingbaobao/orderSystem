package com.ffcs.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.OrderStatistics;
import com.ffcs.order.entity.Statistics;
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
        JSONObject json=new JSONObject();
        OrderStatistics us=qsm.selectById(commodityId);
        String gson= json.toJSONString(us);
        return gson;
    }

    @RequestMapping(path = "/QuerySta", method = RequestMethod.POST)
    public String QuerySta(@RequestParam String updateTime) {
        JSONObject json=new JSONObject();
        Statistics us=qsm.selectSta(updateTime);
        String gson= json.toJSONString(us);
        return gson;
    }




}
