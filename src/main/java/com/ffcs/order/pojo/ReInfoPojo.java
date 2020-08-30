package com.ffcs.order.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class ReInfoPojo {

    String code;
    String message;
    Map<String,String> data;

}



