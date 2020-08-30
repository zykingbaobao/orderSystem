package com.ffcs.order.mapper;


import com.ffcs.order.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffManageMapper {
    public int  insert(Staff staff);
    public int  update(Staff staff);
    public List<Staff> select();
}
