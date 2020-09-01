package com.ffcs.order.mapper;

import java.util.List;
import java.util.Map;

import com.ffcs.order.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper{
	 Commodity queryByCommodity(Commodity commodity);//查询商品
	 List<Commodity> select();//查询商品
	 int  editCommodity(Commodity commodity);//编辑
	 int delete(Integer commodityId);//删除
	 int insert(Commodity commodity);//添加
}