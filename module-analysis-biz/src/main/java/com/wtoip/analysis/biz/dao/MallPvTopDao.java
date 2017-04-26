package com.wtoip.analysis.biz.dao;

import java.util.List;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description 店铺曝光率按行业排行
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
public interface MallPvTopDao extends Dao<MallPvTop>{
	
	/** 
	 * @param startDate
	 * @param endDate
	 */
	void analysisMallPvTopByDateRange(String startDate, String endDate);
	
	/**
	 * 查询店铺最后2条排行记录
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	List<MallPvTop> findLastTwoData(String app,String memberId,String mallId);
}
