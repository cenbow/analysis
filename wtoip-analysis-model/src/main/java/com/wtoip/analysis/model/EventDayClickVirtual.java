package com.wtoip.analysis.model;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
@Document(collection = "event_day_click_virtual")
public class EventDayClickVirtual extends EventDayClick{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
