package com.wtoip.analysis.biz.service;

import java.util.List;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.MallDesignTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
public interface MallDesignTopService extends Service<MallDesignTop>{
	/** 
	 * @param createDate
	 */
	void analysisMallDesignTopByDay(String createDate);
	
	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallDesignTop> findLastTwoData(String app,String memberId,String mallId);
}
