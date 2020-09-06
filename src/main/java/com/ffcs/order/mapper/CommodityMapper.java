package com.ffcs.order.mapper;

import java.util.List;
import java.util.Map;

import com.ffcs.order.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommodityMapper{
	 Commodity queryByCommodity(Commodity commodity);//查询商品
	 List<Commodity> select();//查询商品
	List<Commodity> selectBypage(Integer offset,Integer limit);
	Commodity selectOne(Integer staffId);//查询单个商品
	 int  editCommodity(Commodity commodity);//编辑
	 int delete(@Param("commodityId")Integer commodityId);//删除
	 int insert(Commodity commodity);//添加

	@Select("select * from t_commodity where sortId=#{sortId}")
	List<Commodity>getListBySortId(int sortId);
}