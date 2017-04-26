package com.wtoip.analysis.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.LogPvDao;
import com.wtoip.analysis.biz.service.LogPvService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.LogPv;
/**
 * 
 * @author 木四点
 * @date 2017年3月21日
 */
@Service("logPvService")
public class LogPvServiceImpl extends BaseService<LogPv> implements LogPvService{
	
	@Resource
	private LogPvDao logPvDao;
	
	@Override
	protected Dao<LogPv> getDao() {
		return logPvDao;
	}

}
