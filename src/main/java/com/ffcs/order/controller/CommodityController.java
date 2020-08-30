package com.ffcs.order.controller;
import javax.servlet.http.HttpServletRequest;

import com.ffcs.order.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodity")   
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    //查询所有商品
    @RequestMapping("/findAll.action")
    public String findAll(HttpServletRequest request) {//分页查询currentPage

        return "";
    }

    //添加商品
    @RequestMapping("/add.action")
    @ResponseBody
    public String add(Commodity commodity) {

        return "OK";

    }
    //编辑
    @RequestMapping("/edit.action")
    @ResponseBody
    public void edit(Commodity commodity) {


    }

    //删除心愿单
    @RequestMapping("/delete.action")
    @ResponseBody
    public void delete(int id) {
        commodityService.deleteCommodity(id);

    }
}