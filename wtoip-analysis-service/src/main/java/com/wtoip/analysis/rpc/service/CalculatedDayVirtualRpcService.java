package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
public interface CalculatedDayVirtualRpcService{
	
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
