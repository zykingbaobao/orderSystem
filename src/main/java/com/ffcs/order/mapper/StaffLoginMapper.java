package com.ffcs.order.mapper;


import com.ffcs.order.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffLoginMapper {
    public Staff select(String StaffId, String password) ;

}
