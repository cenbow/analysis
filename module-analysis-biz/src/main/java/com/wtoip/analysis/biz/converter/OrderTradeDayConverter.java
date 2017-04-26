package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.OrderTradeDayAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.OrderTradeDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Component
public class OrderTradeDayConverter extends BaseConverter<OrderTradeDayAdapter,OrderTradeDay>{

	
	@Override
	public OrderTradeDay convert(OrderTradeDayAdapter s) {
		OrderTradeDay orderTradeDay = new OrderTradeDay();
		OrderTradeDay._Id id = new OrderTradeDay._Id();
		id.setCreateDate(s.getCreateDate());
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		id.setTradeId(s.getTradeId());
		id.setTradeName(s.getTradeName());
		orderTradeDay.setId(id);
		
		OrderTradeDay._Value value = new OrderTradeDay._Value();
		value.setQty(s.getQty());
		orderTradeDay.setValue(value);
		
		return orderTradeDay;
	}

}
