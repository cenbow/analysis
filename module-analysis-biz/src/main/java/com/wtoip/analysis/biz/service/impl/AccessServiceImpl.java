package com.wtoip.analysis.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.AccessDao;
import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.Access;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Service("accessService")
public class AccessServiceImpl extends BaseService<Access> implements AccessService{

	@Resource
	private AccessDao accessDao;
	
	@Override
	protected Dao<Access> getDao() {
		return accessDao;
	}

	@Override
	public Access findLastByCookieAndIp(String cookie, String ip) {
		return accessDao.findLastByCookieAndIp(cookie, ip);
	}

}
