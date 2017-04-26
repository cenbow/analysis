package com.wtoip.analysis.biz.service;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.model.Access;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface AccessService extends Service<Access>{
	
	/**
	 * 查找用户最近一个访问记录
	 * @param cookie
	 * @param ip
	 * @return
	 */
	Access findLastByCookieAndIp(String cookie,String ip);
}
