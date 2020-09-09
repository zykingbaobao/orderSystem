package com.ffcs.order.mapper;

import com.ffcs.order.entity.Cart;
import com.ffcs.order.entity.Commodity;
import com.ffcs.order.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select cd.*,c.amount,c.userId,c.id from t_cart c,t_commodity cd where c.userId=#{userId} and c.commodityId=cd.commodityId")
    public List<Cart> getCartList(User user);

    @Update("update t_cart SET amount=amount+1 where id=#{id}")
    public int addItem(Integer id);

    @Update("update t_cart SET amount=amount-1 where id=#{id}")
    public int removeItem(int id);
}