package com.ffcs.order.controller;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/commodity")
@RestController
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    //��ѯ������Ʒ
    @RequestMapping(path = "/findAll.action",method = RequestMethod.GET)
    public String findAll() {//��ҳ��ѯcurrentPage

        return commodityService.findAll();
    }

    //�����Ʒ
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
    //�༭
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

    //ɾ����Ʒ
    @RequestMapping(path ="/delete.action",method = RequestMethod.POST)
    @ResponseBody
    public String delete(String commodityId) {
       return commodityService.deleteCommodity(commodityId);

    }
}