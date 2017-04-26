package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.service.OrderDayService;
import com.wtoip.analysis.model.OrderDay;
import com.wtoip.analysis.rpc.service.OrderDayRpcService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Service("orderDayRpcService")
public class OrderDayRpcServiceImpl implements OrderDayRpcService{

	@Resource
	private OrderDayService orderDayService;
	
	@Override
	public List<OrderDay> findOrderDateRange(String startDate, String endDate, String app, String memberId)
			throws Exception {
		return orderDayService.findOrderDateRange(startDate, endDate, app, memberId);
	}

	
	@Override
	public OrderDay findOrderDateRangeSum(String startDate, String endDate, String app, String memberId) {
		return orderDayService.findOrderDateRangeSum(startDate, endDate, app, memberId);
	}
}
