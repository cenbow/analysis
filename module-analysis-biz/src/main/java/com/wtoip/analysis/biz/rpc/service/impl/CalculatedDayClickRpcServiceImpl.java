package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.CalculatedDayClickService;
import com.wtoip.analysis.model.EventDayClick;
import com.wtoip.analysis.rpc.service.CalculatedDayClickRpcService;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
@Service("calculatedDayClickRpcService")
public class CalculatedDayClickRpcServiceImpl implements CalculatedDayClickRpcService{
	
	@Resource
	private CalculatedDayClickService calculatedDayClickService;
	
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
	@Override
	public List<EventDayClick> findMallEventDateRange (String startDate,String endDate,String app,String memberId,String mallId,String event) throws Exception{
			return calculatedDayClickService.findMallEventDateRange(startDate, endDate, app, memberId, mallId, event);
	}


	@Override
	public EventDayClick findMallEventDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId, String event) {
		return calculatedDayClickService.findMallEventDateRangeSum(startDate, endDate, app, memberId, mallId, event);
	}
	
}
