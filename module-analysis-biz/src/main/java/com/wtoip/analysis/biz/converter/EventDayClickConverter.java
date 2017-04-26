package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.EventDayClickAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.EventDayClick;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class EventDayClickConverter extends BaseConverter<EventDayClickAdapter,EventDayClick>{

	
	@Override
	public EventDayClick convert(EventDayClickAdapter s) {
		EventDayClick eventDayClick = new EventDayClick();
		EventDayClick._Id id = new EventDayClick._Id();
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		id.setEvent(s.getEvent());
		
		EventDayClick._Value value = new EventDayClick._Value();
		value.setPv(s.getPv());
		value.setUv(s.getUv());
		value.setIp(s.getIp());
		
		eventDayClick.setId(id);
		eventDayClick.setValue(value);
		
		return eventDayClick;
	}
}
