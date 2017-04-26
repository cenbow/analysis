package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.OrderDayAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.OrderDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Component
public class OrderDayConverter extends BaseConverter<OrderDayAdapter,OrderDay>{

	
	@Override
	public OrderDay convert(OrderDayAdapter s) {
		OrderDay orderDay = new OrderDay();
		
		OrderDay._Id id = new OrderDay._Id();
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		orderDay.setId(id);
		
		OrderDay._Value value = new OrderDay._Value();
		value.setTradeFee(s.getTradeFee());
		value.setCommissionFee(s.getCommissionFee());
		value.setTotalFee(s.getTotalFee());
		value.setTotalQty(s.getTotalQty());
		value.setValidQty(s.getValidQty());
		value.setInvalidQty(s.getInvalidQty());
		orderDay.setValue(value);
		
		return orderDay;
	}

}
