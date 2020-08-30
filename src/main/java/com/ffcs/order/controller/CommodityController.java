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

    //��ѯ������Ʒ
    @RequestMapping("/findAll.action")
    public String findAll(HttpServletRequest request) {//��ҳ��ѯcurrentPage

        return "";
    }

    //�����Ʒ
    @RequestMapping("/add.action")
    @ResponseBody
    public String add(Commodity commodity) {

        return "OK";

    }
    //�༭
    @RequestMapping("/edit.action")
    @ResponseBody
    public void edit(Commodity commodity) {


    }

    //ɾ����Ը��
    @RequestMapping("/delete.action")
    @ResponseBody
    public void delete(int id) {
        commodityService.deleteCommodity(id);

    }
}