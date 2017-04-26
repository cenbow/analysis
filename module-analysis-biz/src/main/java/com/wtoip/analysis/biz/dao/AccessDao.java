package com.wtoip.analysis.biz.dao;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.model.Access;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface AccessDao extends Dao<Access>{
	
	/**
	 * 查找用户最近一个访问记录
	 * @param cookie
	 * @param ip
	 * @return
	 */
	Access findLastByCookieAndIp(String cookie,String ip);
}
