package com.wtoip.analysis.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.ShopDesignDao;
import com.wtoip.analysis.biz.service.ShopDesignService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.ShopDesign;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Service("shopDesignService")
public class ShopDesignServiceImpl extends BaseService<ShopDesign> implements ShopDesignService{

	@Resource
	private ShopDesignDao shopDesignDao;
	
	@Override
	protected Dao<ShopDesign> getDao() {
		return shopDesignDao;
	}

}
