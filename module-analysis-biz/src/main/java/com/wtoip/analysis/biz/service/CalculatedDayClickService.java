package com.wtoip.analysis.biz.service;

import java.util.List;
import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.EventDayClick;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
public interface CalculatedDayClickService extends Service<EventDayClick>{

	/**
	 * 按时间查询事件PV,UV,IP
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 */
	EventDayClick findMallEventDay(String date,String app,String memberId,String mallId,String event);

	
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
