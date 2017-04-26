package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.CalculatedEventDayAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.CalculatedDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月1日
 */
@Component
public class CalculatedDayConverter extends BaseConverter<CalculatedEventDayAdapter,CalculatedDay>{

	@Override
	public CalculatedDay convert(CalculatedEventDayAdapter s) {
		CalculatedDay calculatedDay = new CalculatedDay();
		
		CalculatedDay._Id id = new CalculatedDay._Id();
		id.setCreateDate(s.getCreateDate());
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		calculatedDay.setId(id);
		
		CalculatedDay._Value value = new CalculatedDay._Value();
		value.setPv(s.getPv());
		value.setUv(s.getUv());
		value.setIp(s.getIp());
		calculatedDay.setValue(value);
		
		return calculatedDay;
	}

}
