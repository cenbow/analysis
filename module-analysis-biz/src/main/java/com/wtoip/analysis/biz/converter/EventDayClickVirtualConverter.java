package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.EventDayClickVirtualAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.EventDayClickVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class EventDayClickVirtualConverter extends BaseConverter<EventDayClickVirtualAdapter,EventDayClickVirtual>{


	@Override
	public EventDayClickVirtual convert(EventDayClickVirtualAdapter s) {
		EventDayClickVirtual eventDayClickVirtual = new EventDayClickVirtual();
		EventDayClickVirtual._Id id = new EventDayClickVirtual._Id();
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		id.setEvent(s.getEvent());
		
		EventDayClickVirtual._Value value = new EventDayClickVirtual._Value();
		value.setPv(s.getPv());
		value.setUv(s.getUv());
		value.setIp(s.getIp());
		
		eventDayClickVirtual.setId(id);
		eventDayClickVirtual.setValue(value);
		
		return eventDayClickVirtual;
	}

}
