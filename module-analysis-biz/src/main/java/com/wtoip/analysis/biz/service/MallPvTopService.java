package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
public interface MallPvTopService extends Service<MallPvTop>{
	/** 
	 * @param startDate
	 * @param endDate
	 */
	void analysisMallPvTopByDateRange(String startDate, String endDate);
	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallPvTop> findLastTwoData(String app,String memberId,String mallId);
}
