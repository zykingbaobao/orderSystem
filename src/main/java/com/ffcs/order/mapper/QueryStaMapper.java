package com.ffcs.order.mapper;


import com.ffcs.order.entity.orderStatistics;
import com.ffcs.order.entity.statistics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryStaMapper {
    public orderStatistics selectById(String commodityId) ;
    public statistics selectSta(String updateTime) ;
}
