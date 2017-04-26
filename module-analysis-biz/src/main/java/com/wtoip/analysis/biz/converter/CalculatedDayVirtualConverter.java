package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.CalculatedDayVirtualAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class CalculatedDayVirtualConverter extends BaseConverter<CalculatedDayVirtualAdapter,CalculatedDayVirtual>{

	
	@Override
	public CalculatedDayVirtual convert(CalculatedDayVirtualAdapter s) {
		
		CalculatedDayVirtual calculatedDayVirtual = new CalculatedDayVirtual();
		CalculatedDayVirtual._Id id = new CalculatedDayVirtual._Id();
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		id.setIndustryCode1(s.getIndustryCode1());
		id.setIndustryCode2(s.getIndustryCode2());
		
		CalculatedDayVirtual._Value value = new CalculatedDayVirtual._Value();
		value.setPv(s.getPv());
		value.setRpv(s.getRpv());
		value.setUv(s.getUv());
		value.setIp(s.getIp());
		
		calculatedDayVirtual.setId(id);
		calculatedDayVirtual.setValue(value);
		
		return calculatedDayVirtual;
	}

}
