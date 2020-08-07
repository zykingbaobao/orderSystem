package com.ffcs.order.mapper;

import java.util.List;
import java.util.Map;

import com.ffcs.order.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper{
	 Commodity queryByCommodity(Commodity commodity);//查询商品
	 List<Commodity> findCommodity(Map<String,Object>map);//分页查询
	 void editCommodity(Commodity commodity);//编辑
	 void deleteCommodity(int commodityId);//删除
	 void insertCommodity(Commodity commodity);//添加
}