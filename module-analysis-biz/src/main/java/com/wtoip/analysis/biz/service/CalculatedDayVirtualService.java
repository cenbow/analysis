package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
public interface CalculatedDayVirtualService extends Service<CalculatedDayVirtual>{
	/**
	 * 查询店铺某天PV,UV,IP
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	CalculatedDayVirtual findMallDay(String date,String app,String memberId,String mallId,String industryCode1,String industryCode2);
	
	/**
	 * 查询店铺时间范围内PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 * @throws Exception 
	 */
	List<CalculatedDayVirtual> findMallDateRange(String startDate,String endDate,String app,String memberId,String mallId,String industryCode1,String industryCode2) throws Exception;

	/**
	 * 查询店铺时间范围内汇总PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	CalculatedDayVirtual findMallDateRangeSum(String startDate,String endDate,String app,String memberId,String mallId);

}
