package com.ffcs.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.OrderStatistics;
import com.ffcs.order.entity.Statistics;
import com.ffcs.order.mapper.QueryStaMapper;
import com.ffcs.order.service.QueryStaService;
import com.ffcs.order.tools.JWTtool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "统计数据管理")
@RestController
public class QueryStaConttroller {
    @Autowired
    QueryStaService queryStaService;
    @Autowired
    private JWTtool jwTtool;
    @ApiOperation(value = "查询商品类别统计数据接口，入参商品id", notes = "")
    @RequestMapping(path = "/QueryStaById", method = RequestMethod.POST)
    public String QueryStaById(@RequestParam String commodityId) {
//        JSONObject json=new JSONObject();
//        OrderStatistics us=qsm.selectById(commodityId);
//        String gson= json.toJSONString(us);
        return "gson";
    }
    @ApiOperation(value = "按天查询统计数据接口", notes = "")
    @RequestMapping(path = "/QuerySta", method = RequestMethod.POST)
    public String QuerySta() {

        return queryStaService.querySta();
    }




}
