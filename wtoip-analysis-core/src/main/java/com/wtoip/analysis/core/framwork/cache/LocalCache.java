package com.wtoip.analysis.core.framwork.cache;

/** 
 *  @Description:局部缓存
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
public interface LocalCache {
	
	/**
	 * 
	 * @param namespace
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	<T> void put(String namespace,String cacheName, String key, T value);
	
	
	/**
	 * 
	 * @param namespace
	 * @param cacheName
	 * @param key
	 * @return
	 */
	<T> T get(String namespace,String cacheName, String key);
	
	
	/**
	 * 
	 * @param namespace
	 * @param cacheName
	 * @param key
	 */
	void remove(String namespace,String cacheName, String key);
	
}
