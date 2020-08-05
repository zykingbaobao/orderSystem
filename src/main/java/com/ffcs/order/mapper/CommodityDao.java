package com.ffcs.order.dao;

import java.util.List;
import java.util.Map;

import com.ffcs.order.entity.commodity;

public interface commodityDao{
	 commodity queryByCommodity(commodity commodity);//查询商品
	 List<commodity> findCommodity(Map<String,Object>map);//分页查询
	 void editCommodity(commodity commodity);//编辑
	 void deleteCommodity(int commodityId);//删除
	 void insertCommodity(commodity commodity);//添加
}