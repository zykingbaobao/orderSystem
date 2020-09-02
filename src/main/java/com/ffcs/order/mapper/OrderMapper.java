package com.ffcs.order.mapper;


import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<Order> queryOrderByPage(String userId, int pageNum, int pageSize);
    public int  deleteOrderById(String orderId);
    public int  insertCancelOrder(Cancelorderapplication cancelorderapplication);
    public List<Order> queryOrderList();
    public List<Cancelorderapplication> queryCancelList();
    public int updateOrder(int orderId, int status);
    public int updateCancelOrder(int orderId, String feedback, int status);
}
