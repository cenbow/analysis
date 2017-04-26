package com.wtoip.analysis.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.EventDao;
import com.wtoip.analysis.biz.service.EventService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
@Service("eventService")
public class EventServiceImpl extends BaseService<Event> implements EventService{

	@Resource
	private EventDao eventPvDao;
	
	@Override
	protected Dao<Event> getDao() {
		
		return eventPvDao;
	}

	@Override
	public List<Event> findAll() {
		return eventPvDao.findAll();
	}

}
