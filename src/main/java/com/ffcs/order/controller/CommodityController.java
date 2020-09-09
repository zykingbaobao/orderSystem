package com.ffcs.order.controller;
import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.pojo.Page;
import com.ffcs.order.service.CommodityService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity")
@RestController
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    //查询所有商品
    @RequestMapping(path = "/findAll.action",method = RequestMethod.POST)
    public String findAll(@RequestBody Page page) {//分页查询currentPage

        return commodityService.findAll(page);
    }
    //查询单个商品
    @RequestMapping(path = "/findOne",method = RequestMethod.POST)
    public String findOne(@RequestBody Commodity commodity) {

        return commodityService.findOne(commodity.getCommodityId());
    }

    //添加商品
    @RequestMapping(path ="/add.action",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Commodity commodity) {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String ss=simpleDateFormat.format(date);
        commodity.setCreateTime(ss);
        commodity.setUpdateTime(ss);
        return commodityService.insertCommodity(commodity);
    }
    //编辑
    @RequestMapping(path ="/edit.action",method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody Commodity commodity
                     ) {


               return commodityService.editCommodity(commodity);
    }

    //删除商品
    @RequestMapping(path ="/delete.action",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody String map) {
        JSONObject mapJson=JSONObject.parseObject(map);
        return   commodityService.deleteCommodity(Integer.valueOf(mapJson.get("commodityId").toString()));




    }

    //根据分类获取商品
    @PostMapping("eleme/menu/list")
    @ResponseBody
    public String getListBySortId(@RequestBody Commodity commodity) {
        System.out.println("sortId="+commodity.getSortId());
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> data = new HashMap<String,Object>();
        Gson gson = new Gson();
        List<Commodity> list = commodityService.getListBySortId(commodity.getSortId());

        for(int i =0;i<list.size();i++){
            System.out.println("name="+list.get(i).getCommodityName());
        }
        if(list!=null){
            data.put("list",list);
            map.put("code",0);
            map.put("message","成功");
            map.put("data",data);
        }else{
            map.put("code",-1);
            map.put("message","失败");
        }

        return gson.toJson(map);

    }
}