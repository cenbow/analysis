package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.EventDayClickVirtual;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
public interface CalculatedDayClickVirtualRpcService{
	
	/**
	 * 按时间范围查询事件PV,UV,IP
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 * @throws Exception 
	 */
	List<EventDayClickVirtual> findMallEventDateRange(String startDate,String endDate,String app,String memberId,String mallId,String event) throws Exception;
	
	/**
	 * 按时间范围查询事件汇总PV,UV,IP
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 * @throws Exception 
	 */
	EventDayClickVirtual findMallEventDateRangeSum(String startDate,String endDate,String app,String memberId,String mallId,String event) ;

}
