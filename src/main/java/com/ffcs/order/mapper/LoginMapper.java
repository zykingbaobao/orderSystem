package com.ffcs.order.mapper;


import com.ffcs.order.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public User select(String userId, String password) ;

}
