package com.wtoip.analysis.core.framwork.lock;

import java.util.concurrent.TimeUnit;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月17日
 */
public interface DLock{

	/**
	 * 获得所
	 * @param time 超时时间
	 * @param unit 单位
	 * @return
	 * @throws InterruptedException
	 */
	boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
	
	/**
	 * 释放锁
	 */
	void unlock();
}
