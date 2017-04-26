package com.wtoip.analysis.biz.dao;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.AccessClick;

/** 
 */
public interface AccessClickDao extends Dao<AccessClick>{
	
	/**
	 * 按店铺-事件维度计算pv,uv,ip,st
	 * @param createDate
	 */
	void analysisEventDayByDate(String createDate);

}
