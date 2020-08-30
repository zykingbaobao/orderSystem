package com.ffcs.order.service;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.order.entity.Staff;
import com.ffcs.order.mapper.StaffManageMapper;
import com.ffcs.order.pojo.ReInfoPojo;
import com.ffcs.order.pojo.ReInfoPojo2;
import com.ffcs.order.tools.JWTtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffManageService {
    @Autowired
    private JWTtool jwTtool;
   @Resource
    private StaffManageMapper re;

    public String regisiter( String staffName,
                             String permissionId,
                             String password){

        Staff staff=new Staff();
        JSONObject json=new JSONObject();
        staff.setStaffName(staffName);
        staff.setPermissionId(permissionId);
        staff.setPassword(password);
        if(re.insert(staff)>=1){

            Map<String,String> data=new HashMap<>();
            data.put("code","1");
            data.put("message","注册成功！");
           String gson= json.toJSONString( data);
            return gson;
        }else {
            Map<String,String> data=new HashMap<>();
            data.put("code","0");
            data.put("message","注册失败！");
            String gson= json.toJSONString( data);
            return gson;
        }

    }

    public String update( String staffName,
                             String permissionId,
                             String password){

        Staff staff=new Staff();
        JSONObject json=new JSONObject();
        staff.setStaffName(staffName);
        staff.setPermissionId(permissionId);
        staff.setPassword(password);
        if(re.update(staff)>=1){

            Map<String,String> data=new HashMap<>();
            data.put("code","1");
            data.put("message","更新成功！");
            String gson= json.toJSONString( data);
            return gson;
        }else {
            Map<String,String> data=new HashMap<>();
            data.put("code","0");
            data.put("message","更新失败！");
            String gson= json.toJSONString( data);
            return gson;
        }

    }
    public String select(){

        Staff staff=new Staff();
        JSONObject json=new JSONObject();
        List<Staff> list=null;
        if(re.select().size()!=0){
            Map<String,String> data=new HashMap<>();
            list=new ArrayList<Staff>();
            list=re.select();
          List<Map<String,String>> lists=new ArrayList<Map<String,String>>();
            for (int i=0;i<list.size();i++){
               data=new HashMap<>();
               data.put("staffId",Integer.toString(list.get(i).getStaffId()));
                data.put("staffName",list.get(i).getStaffName());
                data.put("password",list.get(i).getPassword());
                data.put("permissionId",list.get(i).getPermissionId());
                lists.add(data);
            }
            ReInfoPojo2 reInfoPojo2=new ReInfoPojo2();
            reInfoPojo2.setCode("1");
            reInfoPojo2.setData(lists);
            reInfoPojo2.setMessage("查询列表成功！");
            String gson= json.toJSONString(data);
            return gson;



        }else {
            Map<String,String> data=new HashMap<>();
            ReInfoPojo reInfoPojo=new ReInfoPojo();
            reInfoPojo.setCode("0");
            reInfoPojo.setData(data);
            reInfoPojo.setMessage("查询列表为空！");
            String gson= json.toJSONString(reInfoPojo);
            return gson;
        }

    }

}
