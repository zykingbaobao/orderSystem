package com.ffcs.order.mapper;


import com.ffcs.order.entity.Cancelorderapplication;
import com.ffcs.order.entity.Detailorder;
import com.ffcs.order.entity.Order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<Order> queryOrderByPage(String userId, int pageNum, int pageSize);
    public int  deleteOrderById(String orderId);
    public int  insertCancelOrder(Cancelorderapplication cancelorderapplication);
    public List<Order> queryOrderList();
    public List<Cancelorderapplication> queryCancelList();
    public int updateOrder(Integer orderId, Integer status);
    public int updateCancelOrder(Integer orderId, String feedback, String status);
    public List<Detailorder> queryOrderDetail(Integer orderId);
    public Cancelorderapplication queryCancelOrderById(Integer orderId);
    public String queryCommodityNameById(Integer commodityId);

    @Select("select * from t_order where 1=1 and userId=#{userId}")
    public List<Order> getOrderByUserId(Order order);

    @Select("select * from t_order where 1=1 and status=#{status} and userId=#{userId}")
    public List<Order> getOrderByStatus(Order order);
}
