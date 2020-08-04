package com.ffcs.order.mapper;


import com.ffcs.order.entity.order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<order> queryOrderByPage(String userId, int pageNum, int pageSize);
    public int  deleteOrderById(String orderId);
}
