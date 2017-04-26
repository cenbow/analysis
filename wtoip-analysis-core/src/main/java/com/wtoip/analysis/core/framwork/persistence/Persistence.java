package com.wtoip.analysis.core.framwork.persistence;

import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;

/** 
 *  @Description:持久层基础接口
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface Persistence<E>{

	/**
	 * 
	 * @param entity
	 */
	void insert(E entity);
	/**
	 * 
	 * @param entity
	 */
	void update(E entity);
	/**
	 * 
	 * @param id
	 */
	void deleteById(Object id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	E findById(Object id);
	/**
	 * 
	 * @param page
	 * @param propName
	 * @param propValue
	 * @return
	 */
	PageResult<E> findAllPage(Page page,String[] propName, Object[] propValue);
}
