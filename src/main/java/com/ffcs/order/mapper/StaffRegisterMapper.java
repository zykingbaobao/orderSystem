package com.ffcs.order.mapper;


import com.ffcs.order.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffRegisterMapper {
    public int  insert(Staff staff);

}
