package com.ffcs.order.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public void insert(String userId,String password) ;

}
