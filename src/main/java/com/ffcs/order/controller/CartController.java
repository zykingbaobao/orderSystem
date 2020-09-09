package com.ffcs.order.controller;

import com.ffcs.order.entity.Cart;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.entity.User;
import com.ffcs.order.mapper.CartMapper;
import com.ffcs.order.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/eleme/cart")
@RestController
public class CartController {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    UserMapper userMapper;

    @PostMapping("list")
    @ResponseBody
    public String getListByUserId(@RequestBody User user) {
        System.out.println("userId=" + user.getUserId());
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        Gson gson = new Gson();

        int count=0;
        Double price =0.0;

        List<Cart> list =cartMapper.getCartList(user);
        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                count+=list.get(i).getAmount();
                price+=list.get(i).getAmount()*list.get(i).getCommodityMoney();
            }

            data.put("list",list);
            data.put("price",price);
            data.put("count",count);
            map.put("data",data);
            map.put("message","成功");
            map.put("code",0);
        }else{
            map.put("message","失败");
            map.put("code",-1);
        }
        return gson.toJson(map);
    }

    @PostMapping("addItem")
    @ResponseBody
    public String addItem(@RequestBody Map<String,Object> request) {
        System.out.println("id="+request.get("id"));
        System.out.println("userId="+request.get("userId"));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        Gson gson = new Gson();
        int id = Integer.parseInt(request.get("id")+"");
        String userId = request.get("userId")+"";
        int idAdd = cartMapper.addItem(id);
        User user = userMapper.getUserById(userId).get(0);
        int count=0;
        Double price =0.0;

        List<Cart> list =cartMapper.getCartList(user);
        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                count+=list.get(i).getAmount();
                price+=list.get(i).getAmount()*list.get(i).getCommodityMoney();
            }
            data.put("list",list);
            data.put("price",price);
            data.put("count",count);
            map.put("data",data);
            map.put("message","成功");
            map.put("code",0);
        }else{
            map.put("message","失败");
            map.put("code",-1);
        }
        return gson.toJson(map);
    }

    @PostMapping("removeItem")
    @ResponseBody
    public String removeItem(@RequestBody Map<String,Object> request) {
        System.out.println("id="+request.get("id"));
        System.out.println("userId="+request.get("userId"));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        Gson gson = new Gson();
        int id = Integer.parseInt(request.get("id")+"");
        String userId = request.get("userId")+"";
        int idremove = cartMapper.removeItem(id);
        User user = userMapper.getUserById(userId).get(0);
        int count=0;
        Double price =0.0;

        List<Cart> list =cartMapper.getCartList(user);
        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                count+=list.get(i).getAmount();
                price+=list.get(i).getAmount()*list.get(i).getCommodityMoney();
            }
            data.put("list",list);
            data.put("price",price);
            data.put("count",count);
            map.put("data",data);
            map.put("message","成功");
            map.put("code",0);
        }else{
            map.put("message","失败");
            map.put("code",-1);
        }
        return gson.toJson(map);
    }
}  