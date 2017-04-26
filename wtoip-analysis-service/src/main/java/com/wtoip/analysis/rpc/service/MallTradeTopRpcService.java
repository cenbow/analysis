package com.wtoip.analysis.rpc.service;

import java.util.List;

import com.wtoip.analysis.model.MallTradeTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
public interface MallTradeTopRpcService {
	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallTradeTop> findLastTwoData(String app,String memberId,String mallId);
}
