package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.OrderDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public interface OrderDayService extends Service<OrderDay>{
	/**
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @return
	 * @throws Exception 
	 */
	List<OrderDay> findOrderDateRange(String startDate,String endDate,String app,String memberId) throws Exception;
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @return
	 */
	OrderDay findOrderDateRangeSum(String startDate,String endDate,String app,String memberId);

}
