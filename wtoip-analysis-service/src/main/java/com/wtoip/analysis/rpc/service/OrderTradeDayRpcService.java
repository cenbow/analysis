package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.OrderTradeDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
public interface OrderTradeDayRpcService {
	/**
	 * 查询时间范围内top n
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param n
	 * @return
	 */
	List<OrderTradeDay> findTopNDateRange(String startDate,String endDate,String app,String memberId,long n);
}
