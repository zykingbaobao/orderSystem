package com.ffcs.order.service;

import com.ffcs.order.entity.Commodity;
import com.ffcs.order.mapper.CommodityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommodityService {
	  @Autowired
	  private CommodityDao commodityDao;
	    public void deleteCommodity(int cid) {//ɾ��
	    	commodityDao.deleteCommodity(cid);
	    }
	    public Commodity queryByCommodity(Commodity commodity) {
			return commodityDao.queryByCommodity(commodity);
		}
	    public void editCommodity(Integer cid) {
			commodityDao.deleteCommodity(cid);
		}
	    public void insertCommodity(Commodity commodity) {
	    	commodityDao.insertCommodity(commodity);
	    }



	




}
