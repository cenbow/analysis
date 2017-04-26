package com.wtoip.analysis.biz.dao;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.Order;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
public interface OrderDao extends Dao<Order>{

	void analysisOrderDayByDate(String t);
}
