package com.ffcs.order.mapper;


import com.ffcs.order.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public user select(String userId, String password) ;

}
