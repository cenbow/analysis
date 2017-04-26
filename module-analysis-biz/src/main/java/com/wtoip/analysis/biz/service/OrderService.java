package com.wtoip.analysis.biz.service;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.Order;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
public interface OrderService extends Service<Order>{

	void analysisOrderDayByDate(String t);

}
