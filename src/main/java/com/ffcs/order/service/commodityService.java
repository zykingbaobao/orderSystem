package com.ffcs.order.service;

import com.ffcs.order.dao.commodityDao;
import com.ffcs.order.entity.commodity;

@Service
@Transactional
public class commodityService {
	  @Autowired
	  private commodityDao commodityDao;
	    public void deleteCommodity(int cid) {//É¾³ý
	    	commodityDao.deleteCommodity(cid);
	    }
	    public commodity queryByCommodity(commodity commodity) {
			return commodityDao.queryByCommodity(commodity);
		}
	    public void editCommodity(Integer cid) {
			commodityDao.deleteCommodity(cid);
		}
	    public void insertCommodity(commodity commodity) {
	    	commodityDao.insertCommodity(commodity);
	    }



	




}
