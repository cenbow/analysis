package com.wtoip.analysis.core.framwork.service.impl;

import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.Service;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public abstract class BaseService<E> implements Service<E>{
	
	protected abstract Dao<E> getDao();
	
	@Override
	public void insert(E entity) {
		getDao().insert(entity);
	}
	
	@Override
	public void update(E entity) {
		getDao().update(entity);
	}
	
	@Override
	public void deleteById(Object id) {
		getDao().deleteById(id);
	}

	@Override
	public E findById(Object id) {
		return getDao().findById(id);
	}
	
	@Override
	public PageResult<E> findAllPage(Page page,String[] propName, Object[] propValue){
		return getDao().findAllPage(page, propName, propValue);
	}
}
