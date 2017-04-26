package com.wtoip.analysis.biz.dao.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.EventDao;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
@Repository("eventDao")
public class EventDaoImpl extends BaseDao<Event> implements EventDao{

	@Cacheable("eventCache")
	@Override
	public List<Event> findAll() {
		return mongoTemplate.findAll(entityClass);
	}

}
