package com.wtoip.analysis.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.MallDesignTopDao;
import com.wtoip.analysis.biz.service.MallDesignTopService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.MallDesignTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Service("mallDesignTopService")
public class MallDesignTopServiceImpl extends BaseService<MallDesignTop> implements MallDesignTopService{
	
	@Resource
	private MallDesignTopDao mallDesignTopDao;

	@Override
	protected Dao<MallDesignTop> getDao() {
		return mallDesignTopDao;
	}

	@Override
	public void analysisMallDesignTopByDay(String createDate) {
		mallDesignTopDao.analysisMallDesignTopByDay(createDate);
	}

	@Override
	public List<MallDesignTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallDesignTopDao.findLastTwoData(app, memberId, mallId);
	}

}
