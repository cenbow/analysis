package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.MallTradeTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public interface MallTradeTopService extends Service<MallTradeTop>{

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	void analysisMallTradeTopByDateRange(String startDate, String endDate);

	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallTradeTop> findLastTwoData(String app,String memberId,String mallId);
}
