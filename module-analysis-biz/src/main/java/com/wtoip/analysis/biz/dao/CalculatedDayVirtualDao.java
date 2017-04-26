package com.wtoip.analysis.biz.dao;

import java.util.List;

import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description 虚拟数据
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
public interface CalculatedDayVirtualDao extends Dao<CalculatedDayVirtual>{
	/**
	 * 查询店铺某天PV,UV,IP
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	CalculatedDayVirtual findMallDay(String date,String app,String memberId,String mallId);
	
	/**
	 * 查询店铺时间范围内PV,UV,IP
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<CalculatedDayVirtual> findMallDateRange(String startDate,String endDate,String app,String memberId,String mallId);

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
	
	/**
	 * 查询时间范围内的聚合结果
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	PageResult<CalculatedDayVirtual> findMallAggregationDateRange(Page page,String startDate,String endDate);
}
