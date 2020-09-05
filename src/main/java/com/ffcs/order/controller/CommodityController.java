package com.ffcs.order.controller;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.service.CommodityService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String findAll() {//分页查询currentPage

        return commodityService.findAll();
    }

    //添加商品
    @RequestMapping(path ="/add.action",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestParam String commodityName,
                      @RequestParam String describe,
                      @RequestParam float commodityMoney,
                      @RequestParam String commodityImageUrl,
                      @RequestParam Integer sortId,
                      @RequestParam String materials) {
        Commodity commodity=new Commodity();
        commodity.setCommodityName(commodityName);
        commodity.setCommodityImageUrl(commodityImageUrl);
        commodity.setDescribe(describe);
        commodity.setCommodityMoney(commodityMoney);
        commodity.setSortId(sortId);
        commodity.setMaterials(materials);
        return commodityService.insertCommodity(commodity);
    }
    //编辑
    @RequestMapping(path ="/edit.action",method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam String commodityId,
                     @RequestParam String describe,
                     @RequestParam float commodityMoney,
                     @RequestParam String commodityImageUrl,
                     @RequestParam Integer sortId,
                     @RequestParam String materials
                     ) {

               Commodity commodity=new Commodity();
               commodity.setCommodityId(Integer.valueOf(commodityId));
               commodity.setCommodityImageUrl(commodityImageUrl);
               commodity.setDescribe(describe);
               commodity.setCommodityMoney(commodityMoney);
               commodity.setSortId(sortId);
               commodity.setMaterials(materials);
               return commodityService.editCommodity(commodity);
    }

    //删除商品
    @RequestMapping(path ="/delete.action",method = RequestMethod.POST)
    @ResponseBody
    public String delete(String commodityId) {
       return commodityService.deleteCommodity(commodityId);

    }

    //删除商品
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
            map.put("code",0);
            map.put("message","失败");
        }

        return gson.toJson(map);

    }
}