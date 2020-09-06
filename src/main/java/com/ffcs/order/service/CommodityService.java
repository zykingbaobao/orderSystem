package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.CommodityMapper;
import com.ffcs.order.pojo.Page;
import com.ffcs.order.pojo.ReInfoPojo;
import com.ffcs.order.pojo.ReInfoPojo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommodityService {
    @Resource
    private CommodityMapper commodityMapper;
    public String deleteCommodity(Integer commodityId) {
        System.out.println("commodityId="+commodityId);
    int i=0;
    JSONObject json=new JSONObject();
    i=commodityMapper.delete(commodityId);
if(i>=1){

    Map<String,String> data=new HashMap<>();
    data.put("code","0");
    data.put("message","删除商品成功！");
    String gson= json.toJSONString( data);
    return gson;
}else {
    Map<String,String> data=new HashMap<>();
    data.put("code","-1");
    data.put("message","删除商品失败！");
    String gson= json.toJSONString( data);
    return gson;
}

    }
//    public Commodity queryByCommodity(Commodity commodity) {
////        return commodityDao.queryByCommodity(commodity);
//    }
    public String editCommodity(Commodity commodity) {


        JSONObject json=new JSONObject();

        if(commodityMapper.editCommodity(commodity)>=1){

            Map<String,String> data=new HashMap<>();
            data.put("code","0");
            data.put("message","更新商品成功！");
            String gson= json.toJSONString( data);
            return gson;
        }else {
            Map<String,String> data=new HashMap<>();
            data.put("code","-1");
            data.put("message","更新商品失败！");
            String gson= json.toJSONString(data);
            return gson;
        }


//        commodityDao.deleteCommodity(cid);
    }
    public String  insertCommodity(Commodity commodity) {
            JSONObject json=new JSONObject();

            if(commodityMapper.insert(commodity)>=1){

                Map<String,String> data=new HashMap<>();
                data.put("code","0");
                data.put("message","添加商品成功！");
                String gson= json.toJSONString( data);
                return gson;
            }else {
                Map<String,String> data=new HashMap<>();
                data.put("code","-1");
                data.put("message","添加商品失败！");
                String gson= json.toJSONString(data);
                return gson;
            }

    }
    public String findAll(Page page){
        int limit=page.getLimit();
        int offset=page.getOffset();
        offset=offset*limit;

        Commodity commodity=new Commodity();
        JSONObject json=new JSONObject();
        List<Commodity> list=null;
        if(commodityMapper.selectBypage(offset,limit).size()!=0){
            Map<String,String> data=new HashMap<>();
            list=new ArrayList<Commodity>();
            list=commodityMapper.selectBypage(offset,limit);
            List<Map<String,String>> lists=new ArrayList<Map<String,String>>();
            for (int i=0;i<list.size();i++){
                data=new HashMap<>();
                data.put("commodityId",Integer.toString(list.get(i).getCommodityId()));
                data.put("commodityName",list.get(i).getCommodityName());
                data.put("describe",list.get(i).getDescribe());
                data.put("commodityMoney",String.valueOf(list.get(i).getCommodityMoney()));
                data.put("commodityImageUrl",list.get(i).getCommodityImageUrl());
                data.put("sortId",Integer.toString(list.get(i).getSortId()));
                data.put("materials",list.get(i).getMaterials());
                lists.add(data);
            }
            ReInfoPojo2 reInfoPojo2=new ReInfoPojo2();
            reInfoPojo2.setCode("0");
            reInfoPojo2.setData(lists);
            reInfoPojo2.setMessage("查询列表成功！");
            reInfoPojo2.setTotal(commodityMapper.select().size());
            String gson= json.toJSONString(reInfoPojo2);
            return gson;

        }else {
            List<Map<String,String>> lists=new ArrayList<Map<String,String>>();
            ReInfoPojo2 reInfoPojo2=new ReInfoPojo2();
            reInfoPojo2.setCode("-1");
            reInfoPojo2.setData(lists);
            reInfoPojo2.setMessage("查询列表失败！");
            reInfoPojo2.setTotal(0);
            String gson= json.toJSONString(reInfoPojo2);
            return gson;
        }

    }
    public String findOne(Integer commodityId){

        Commodity commodity=new Commodity();
        JSONObject json=new JSONObject();
        if(commodityMapper.selectOne(commodityId).getCommodityName()!=null){
            Map<String,String> data=new HashMap<>();
            commodity=commodityMapper.selectOne(commodityId);
                data=new HashMap<>();
                data.put("commodityId",Integer.toString(commodity.getCommodityId()));
                data.put("commodityName",commodity.getCommodityName());
                data.put("describe",commodity.getDescribe());
                data.put("commodityMoney",String.valueOf(commodity.getCommodityMoney()));
                data.put("commodityImageUrl",commodity.getCommodityImageUrl());
                data.put("sortId",Integer.toString(commodity.getSortId()));
                data.put("materials",commodity.getMaterials());
               data.put("code","0");
               data.put("message","查询成功！");
            String gson= json.toJSONString(data);
            return gson;

        }else {
            Map<String,String> data=new HashMap<>();
            data=new HashMap<>();
            data.put("code","-1");
            data.put("message","查询失败！");
            String gson= json.toJSONString(data);
            return gson;
        }

    }

    public List<Commodity> getListBySortId(int sortId) {
        return commodityMapper.getListBySortId(sortId);
    }
}