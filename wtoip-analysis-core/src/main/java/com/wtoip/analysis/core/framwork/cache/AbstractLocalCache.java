package com.wtoip.analysis.core.framwork.cache;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
public abstract class AbstractLocalCache implements LocalCache{

	/**
	 * 
	 * @param namespace
	 * @param cacheName
	 * @return
	 */
	protected String getFullKey(String namespace, String key){
		return namespace + "." + key;
	}
}
