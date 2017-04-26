package com.wtoip.analysis.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.OrderDao;
import com.wtoip.analysis.biz.service.OrderService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.Order;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
@Service("orderService")
public class OrderServiceImpl extends BaseService<Order> implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	@Override
	protected Dao<Order> getDao() {
		return orderDao;
	}

	@Override
	public void analysisOrderDayByDate(String t) {
		// TODO Auto-generated method stub
		orderDao.analysisOrderDayByDate(t);
	}

}
