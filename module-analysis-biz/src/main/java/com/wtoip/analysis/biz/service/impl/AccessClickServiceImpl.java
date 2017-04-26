package com.wtoip.analysis.biz.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.AccessClickDao;
import com.wtoip.analysis.biz.service.AccessClickService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.AccessClick;


@Service("accessClickService")
public class AccessClickServiceImpl extends BaseService<AccessClick> implements AccessClickService{

	@Resource
	private AccessClickDao accessClickDao;

	@Override
	protected Dao<AccessClick> getDao() {
		return accessClickDao;
	}

	/* (non-Javadoc)
	 * @see com.wtoip.analysis.biz.service.AccessClickService#analysisEventDayByDate(java.lang.String)
	 */
	@Override
	public void analysisEventDayByDate(String createDate) {
		// TODO Auto-generated method stub
		accessClickDao.analysisEventDayByDate(createDate);
	}

	
}
