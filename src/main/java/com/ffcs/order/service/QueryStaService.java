package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Statistics;
import com.ffcs.order.mapper.QueryStaMapper;
import com.ffcs.order.pojo.ReInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryStaService {

    @Autowired
    private QueryStaMapper qsm;

public  String querySta(){

    JSONObject json=new JSONObject();
    Statistics us=qsm.selectSta();
    ReInfoPojo reInfoPojo=new ReInfoPojo();
    reInfoPojo.setCode("1");
    reInfoPojo.setMessage("查询数据成功！");
    Map<String,String> data=new HashMap<>();
    data.put("orderNumber",String.valueOf(us.getOrderNumber()));
    data.put("orderAmount",String.valueOf(us.getOrderAmount()));
    reInfoPojo.setData(data);
    String gson= json.toJSONString(reInfoPojo);
    return gson;
}


}
