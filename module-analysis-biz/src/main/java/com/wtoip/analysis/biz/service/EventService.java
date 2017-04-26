package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
public interface EventService extends Service<Event>{

	/**
	 * 查询所有事件
	 * @return
	 */
	List<Event> findAll();
}
