package com.wtoip.analysis.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.OrderTradeDayDao;
import com.wtoip.analysis.biz.service.OrderTradeDayService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.OrderTradeDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Service("orderTradeDayService")
public class OrderTradeDayServiceImpl extends BaseService<OrderTradeDay> implements OrderTradeDayService{

	@Resource
	private OrderTradeDayDao orderTradeDayDao;
	
	@Override
	protected Dao<OrderTradeDay> getDao() {
		return orderTradeDayDao;
	}

	@Override
	public List<OrderTradeDay> findTopNDateRange(String startDate, String endDate, String app, String memberId,
			long n) {
		return orderTradeDayDao.findTopNDateRange(startDate, endDate, app, memberId, n);
	}

	@Override
	public void analysisOrderTradeDay(String createDate) {
		orderTradeDayDao.analysisOrderTradeDay(createDate);
	}
	
}
