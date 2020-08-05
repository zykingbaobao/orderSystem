package com.ffcs.order.service;

import com.ffcs.order.dao.CommodityDao;
import com.ffcs.order.entity.Commodity;

@Service
@Transactional
public class commodityService {
	  @Autowired
	  private CommodityDao commodityDao;
	    public void deleteCommodity(int cid) {//É¾³ý
	    	commodityDao.deleteCommodity(cid);
	    }
	    public commodity queryByCommodity(Commodity commodity) {
			return commodityDao.queryByCommodity(commodity);
		}
	    public void editCommodity(Integer cid) {
			commodityDao.deleteCommodity(cid);
		}
	    public void insertCommodity(Commodity commodity) {
	    	commodityDao.insertCommodity(commodity);
	    }



	




}
