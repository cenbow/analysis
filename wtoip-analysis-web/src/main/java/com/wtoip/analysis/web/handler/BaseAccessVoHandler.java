package com.wtoip.analysis.web.handler;

import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.web.vo.AccessVo;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月1日
 */
public abstract class BaseAccessVoHandler implements Handler<AccessVo>{

	
	@Override
	public boolean supports(AccessVo t) {
		return supports(t.getEventType(), t.getEvent());
	}

	/**
	 * 
	 * @param eventType
	 * @param event
	 */
	public abstract boolean supports(EventType eventType,String event);
}
