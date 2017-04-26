package com.wtoip.analysis.biz.dao;

import java.util.List;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
public interface EventDao extends Dao<Event>{

	/**
	 * 查询所有事件
	 * @return
	 */
	List<Event> findAll();
}
