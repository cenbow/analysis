package com.wtoip.analysis.biz.rpc.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.OrderService;
import com.wtoip.analysis.core.util.JSR303Util;
import com.wtoip.analysis.model.Order;
import com.wtoip.analysis.rpc.service.OrderRpcService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
@Service("orderRpcService")
public class OrderRpcServiceImpl implements OrderRpcService  {
	
	@Resource
	private OrderService orderService;
	@Override
	public void update(Order order){
		JSR303Util.validate(order);
		orderService.update(order);
	};
}
