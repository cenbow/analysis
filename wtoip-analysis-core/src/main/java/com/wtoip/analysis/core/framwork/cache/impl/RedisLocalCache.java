package com.wtoip.analysis.core.framwork.cache.impl;

import org.redisson.api.RedissonClient;
import com.wtoip.analysis.core.framwork.cache.AbstractLocalCache;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public class RedisLocalCache extends AbstractLocalCache{

	private RedissonClient redisson;
	
	@Override
	public <T> void put(String namespace, String cacheName, String key, T value) {
		String fullKey = getFullKey(namespace,cacheName);
		redisson.getBucket(fullKey).set(value);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String namespace, String cacheName, String key) {
		String fullKey = getFullKey(namespace,cacheName);
		return (T)redisson.getBucket(fullKey).get();
	}

	@Override
	public void remove(String namespace, String cacheName, String key) {
		String fullKey = getFullKey(namespace,cacheName);
		redisson.getBucket(fullKey).delete();
	}


	/**
	 * @return the redisson
	 */
	public RedissonClient getRedisson() {
		return redisson;
	}


	/**
	 * @param redisson the redisson to set
	 */
	public void setRedisson(RedissonClient redisson) {
		this.redisson = redisson;
	}
}
