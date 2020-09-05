package com.ffcs.order.mapper;

import com.ffcs.order.entity.Commoditysort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortMapper {

    @Select("select * from t_commoditysort ")
    List<Commoditysort> getSortList();
}  