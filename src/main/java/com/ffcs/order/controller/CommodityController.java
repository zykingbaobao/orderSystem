package com.ffcs.order.conttroller;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSON;
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
        Commodity commodity = commodityService.queryByCommodity();//idΪint����
        String jsonString = JSON.toJSONString(commodity);//����תΪjson
        System.out.println("jsonString:" + jsonString);
        return jsonString;
    }

    //�����Ʒ
    @RequestMapping("/add.action")
    @ResponseBody
    public String add(Commodity commodity) {
        //���yyyy-MM-dd��ʽ��ʱ��

        String currentTime = commodity.getdate();
        commodity.setdate(currentTime);
        commodityService.addCommodity(commodity);//�����Ը��
        return "OK";

    }
    //�༭
    @RequestMapping("/edit.action")
    @ResponseBody
    public void edit(Commodity commodity) {
        String cid = null;//��Ը��id
        String currentTime = commodity.getWdate();

        commodity.setCommodityid(cid);
        commodityService.editCommodity(commodity);
        return;
    }

    //ɾ����Ը��
    @RequestMapping("/delete.action")
    @ResponseBody
    public void delete(int id) {
        commodityService.deleteCommodity(id);
        return;
    }
}