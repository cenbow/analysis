package com.wtoip.analysis.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.MallPvTopDao;
import com.wtoip.analysis.biz.service.MallPvTopService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
@Service("mallPvTopService")
public class MallPvTopServiceImpl extends BaseService<MallPvTop> implements MallPvTopService{
	
	@Resource
	private MallPvTopDao mallPvTopDao;
	
	@Override
	protected Dao<MallPvTop> getDao() {
		return mallPvTopDao;
	}

	@Override
	public void analysisMallPvTopByDateRange(String startDate, String endDate) {
		mallPvTopDao.analysisMallPvTopByDateRange(startDate, endDate);
	}

	@Override
	public List<MallPvTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallPvTopDao.findLastTwoData(app, memberId, mallId);
	}

}
