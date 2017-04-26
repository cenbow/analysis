package com.wtoip.analysis.biz.dao;

import java.util.List;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.OrderDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public interface OrderDayDao extends Dao<OrderDay>{

	/**
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @return
	 */
	List<OrderDay> findOrderDateRange(String startDate,String endDate,String app,String memberId);
	
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
