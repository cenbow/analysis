/**
 * 
 */
package com.wtoip.analysis.biz.rpc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.ShopDesignDao;
import com.wtoip.analysis.core.util.JSR303Util;
import com.wtoip.analysis.model.ShopDesign;
import com.wtoip.analysis.rpc.service.ShopDecorationService;

/** 
 *  @Description
 *  @author 木四点
 *  @date   2017年4月6日
 */
@Service("shopDecorationService")
public class ShopDecorationServiceImpl implements  ShopDecorationService{

	@Resource
	private ShopDesignDao shopDesignDao;
	
	@Override
	public void insert(ShopDesign entity) {
		JSR303Util.validate(entity);
		shopDesignDao.insert(entity);
	}

	@Override
	public void update(ShopDesign entity) {
		JSR303Util.validate(entity);
		shopDesignDao.update(entity);
	}

}
