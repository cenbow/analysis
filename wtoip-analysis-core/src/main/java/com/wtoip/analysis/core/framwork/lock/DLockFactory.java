package com.wtoip.analysis.core.framwork.lock;

import java.util.concurrent.TimeUnit;
import org.redisson.api.RedissonClient;
import com.wtoip.analysis.core.framwork.lock.impl.RedisLock;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月18日
 */
public class DLockFactory{
	
	private String nameSpace = "lock_";
	
	private RedissonClient redisson;
	
	/**
	 * 获取锁
	 * @param name
	 * @return
	 */
	public DLock getRedisLock(String name){
		return new RedisLock(redisson,nameSpace,name);
	}
	
	/**
	 * 获取锁
	 * @param name
	 * @param expire
	 * @param unit
	 * @return
	 */
	public DLock getRedisLock(String name,long expire, TimeUnit unit){
		return new RedisLock(redisson,nameSpace,name,expire,unit);
	}
	

	public RedissonClient getRedisson() {
		return redisson;
	}

	public void setRedisson(RedissonClient redisson) {
		this.redisson = redisson;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
}
