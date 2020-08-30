package com.ffcs.order.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ReInfoPojo2 {

    String code;
    String message;
    List<Map<String,String>> data;

}



