package com.wtoip.analysis.rpc.service;

import java.util.List;
import com.wtoip.analysis.model.EventDayClick;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
public interface CalculatedDayClickRpcService{

	/**
	 * 按时间范围查询事件PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 * @throws Exception 
	 */
	List<EventDayClick> findMallEventDateRange(String startDate,String endDate,String app,String memberId,String mallId,String event) throws Exception;
	
	/**
	 * 按时间范围查询事件汇总PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 */
	EventDayClick findMallEventDateRangeSum(String startDate,String endDate,String app,String memberId,String mallId,String event);
}
