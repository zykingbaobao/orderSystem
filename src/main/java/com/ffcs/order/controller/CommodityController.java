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

    //查询所有商品
    @RequestMapping("/findAll.action")
    public String findAll(HttpServletRequest request) {//分页查询currentPage
        Commodity commodity = commodityService.queryByCommodity();//id为int类型
        String jsonString = JSON.toJSONString(commodity);//对象转为json
        System.out.println("jsonString:" + jsonString);
        return jsonString;
    }

    //添加商品
    @RequestMapping("/add.action")
    @ResponseBody
    public String add(Commodity commodity) {
        //获得yyyy-MM-dd格式的时间

        String currentTime = commodity.getdate();
        commodity.setdate(currentTime);
        commodityService.addCommodity(commodity);//添加心愿单
        return "OK";

    }
    //编辑
    @RequestMapping("/edit.action")
    @ResponseBody
    public void edit(Commodity commodity) {
        String cid = null;//心愿单id
        String currentTime = commodity.getWdate();

        commodity.setCommodityid(cid);
        commodityService.editCommodity(commodity);
        return;
    }

    //删除心愿单
    @RequestMapping("/delete.action")
    @ResponseBody
    public void delete(int id) {
        commodityService.deleteCommodity(id);
        return;
    }
}