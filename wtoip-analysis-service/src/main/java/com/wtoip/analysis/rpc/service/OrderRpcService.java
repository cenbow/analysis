package com.wtoip.analysis.rpc.service;

import com.wtoip.analysis.model.Order;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
public interface OrderRpcService {

	/**
	 * 
	 * @param order
	 */
	void update(Order order);
}
