package com.wtoip.analysis.core.framwork.lock.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wtoip.analysis.core.framwork.lock.DLock;

/** 
 *  @Description setNX版本(阿里云redis集群不支持eval命令)
 *	@author wanghongwei
 *  @date   2017年4月17日
 */
public class RedisLock implements DLock{
	
	private static Logger log = LoggerFactory.getLogger(RedisLock.class);
	
	private static final int DEFAULT_SLEEP_MILLIS = 100;
	
	private RedissonClient redisson;
	
	private String nameSpace;

	private final String name;
	
	private Long lockValue;
	
	/**
	 * 锁失效时间(毫秒)
	 */
	private long LOCK_EXPIRES_MILLISECONDS;
	
	public RedisLock(RedissonClient redisson,String nameSpace,String name){
		//默认30分钟
		this(redisson,nameSpace,name,30,TimeUnit.MINUTES);
	}
	
	/**
	 * 
	 * @param redisson 
	 * @param name 锁名称
	 * @param expire 锁超时时间
	 * @param unit 单位
	 */
	public RedisLock(RedissonClient redisson,String nameSpace,String name,long expire, TimeUnit unit){
		this.redisson = redisson;
		this.nameSpace = nameSpace;
		this.name = name;
		this.LOCK_EXPIRES_MILLISECONDS = unit.toMillis(expire);
	}
	
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		String lockKey = getLockKey();
		Long timeout = unit.toMillis(time);
		while (timeout >= 0){
			Long serverTime = getServerTime();
			lockValue = serverTime + LOCK_EXPIRES_MILLISECONDS;
			
			if(redisson.getBucket(lockKey).trySet(lockValue)){
				log.info(lockKey + " locked by setNX");
				return true;
			}
			Long currentValue = (Long)redisson.getBucket(lockKey).get();
			//判断锁是否失效
			if(currentValue != null && currentValue < serverTime) {
				Long oldValueStr = (Long)redisson.getBucket(lockKey).getAndSet(lockValue);
				if(oldValueStr!=null && oldValueStr.equals(currentValue)){
					log.info("locked by getSet");
					return true;
				}
			}
			timeout -= DEFAULT_SLEEP_MILLIS;
			Thread.sleep(DEFAULT_SLEEP_MILLIS);
		}
		return false;
	}

	
	@Override
	public void unlock() {
		String lockKey = getLockKey();
		Long currValue = (Long)redisson.getBucket(lockKey).get();
		if(currValue!=null && currValue.equals(lockValue)){
			log.info(lockKey + " unlock");
			redisson.getBucket(lockKey).delete();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private String getLockKey(){
		return nameSpace + "_" + name;
	}

	/**
	 * 获取服务器时间
	 * @return
	 */
	private Long getServerTime(){
        return System.currentTimeMillis();
	}
}
