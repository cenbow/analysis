package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.MallDesignTop;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月11日
 */
public interface MallDesignTopRpcService{
	/** 
	 * @param createDate
	 */
	void analysisMallDesignTopByDay(String createDate);
	
	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallDesignTop> findLastTwoData(String app,String memberId,String mallId);
}
