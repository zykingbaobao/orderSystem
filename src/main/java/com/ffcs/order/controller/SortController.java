package com.ffcs.order.controller;

import com.ffcs.order.entity.Commoditysort;
import com.ffcs.order.entity.User;
import com.ffcs.order.mapper.SortMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SortController {

    @Autowired
    SortMapper sortMapper;

    @ResponseBody
    @GetMapping("eleme/sort/list")
    public String list() {
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> data = new HashMap<String,Object>();
        Gson gson = new Gson();
        List<Commoditysort> sortList = sortMapper.getSortList();
        if(sortList!=null){
            data.put("list",sortList);
            map.put("data",data);
            map.put("code",0);
            map.put("message","成功");
        }else{
            map.put("code",-1);
            map.put("message","失败");
        }

        return gson.toJson(map);
    }
}  