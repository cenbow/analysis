package com.wtoip.analysis.biz.service;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.AccessClick;

/** 
 */
public interface AccessClickService extends Service<AccessClick>{

	/**
	 * 按店铺-事件维度计算pv,uv,ip,st
	 * @param createDate
	 */
	void analysisEventDayByDate(String createDate);
}
