package com.ffcs.order.mapper;


import com.ffcs.order.entity.OrderStatistics;
import com.ffcs.order.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryStaMapper {
    public OrderStatistics selectById(String commodityId) ;
    public Statistics selectSta() ;
}
