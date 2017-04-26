package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.OrderTradeDayService;
import com.wtoip.analysis.model.OrderTradeDay;
import com.wtoip.analysis.rpc.service.OrderTradeDayRpcService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Service("orderTradeDayRpcService")
public class OrderTradeDayRpcServiceImpl implements OrderTradeDayRpcService{

	@Resource
	private OrderTradeDayService orderTradeDayService;

	@Override
	public List<OrderTradeDay> findTopNDateRange(String startDate, String endDate, String app, String memberId,
			long n) {
		
		return orderTradeDayService.findTopNDateRange(startDate, endDate, app, memberId, n);
	}
}
