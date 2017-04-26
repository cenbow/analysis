package com.wtoip.analysis.biz.dao;

import java.util.List;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.MallTradeTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public interface MallTradeTopDao extends Dao<MallTradeTop>{

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param industryCode1
	 * @param industryCode2
	 * @return
	 */
	List<MallTradeTop> findSortMallTradeTop(String startDate,String endDate,String industryCode1,String industryCode2);
	
	/**
	 * 
	 * @param app
	 * @param memberId
	 * @return
	 */
	List<MallTradeTop> findLastTwoData(String app,String memberId);
}
