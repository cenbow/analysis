package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.CalculatedDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
public interface CalculatedDayService extends Service<CalculatedDay>{
	/**
	 * 按店铺维度计算pv,uv,ip,st
	 * @param createDate
	 */
	void analysisDayByDate(String createDate);
	/**
	 * 查询店铺某天PV,UV,IP
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	CalculatedDay findMallDay(String date,String app,String memberId,String mallId);
	
	/**
	 * 查询店铺时间范围内PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<CalculatedDay> findMallDateRange(String startDate,String endDate,String app,String memberId,String mallId);

}
