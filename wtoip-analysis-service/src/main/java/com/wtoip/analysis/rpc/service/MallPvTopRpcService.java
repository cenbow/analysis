package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月11日
 */
public interface MallPvTopRpcService{
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
