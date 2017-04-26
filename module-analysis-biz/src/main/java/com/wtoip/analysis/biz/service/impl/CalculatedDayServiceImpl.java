package com.wtoip.analysis.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.CalculatedDayDao;
import com.wtoip.analysis.biz.service.CalculatedDayService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.CalculatedDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Service("calculatedDayService")
public class CalculatedDayServiceImpl extends BaseService<CalculatedDay> implements CalculatedDayService{

	@Resource
	private CalculatedDayDao calculatedDayDao;
	
	@Override
	protected Dao<CalculatedDay> getDao() {
		return calculatedDayDao;
	}

	@Override
	public CalculatedDay findMallDay(String date, String app, String memberId, String mallId) {
		return calculatedDayDao.findMallDay(date, app, memberId, mallId);
	}

	@Override
	public List<CalculatedDay> findMallDateRange(String startDate, String endDate, String app, String memberId,
			String mallId) {
		return calculatedDayDao.findMallDateRange(startDate, endDate, app, memberId, mallId);
	}

	@Override
	public void analysisDayByDate(String createDate) {
		calculatedDayDao.analysisDayByDate(createDate);
	}

}
