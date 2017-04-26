package org.wtoip.analysis.core.util;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月14日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml","classpath:spring-cache.xml"})
public class RedissonTest {

	@Resource
	private RedissonClient redisson;
	
	@Test
	public void test() throws InterruptedException{
		try{
		
			RLock lock = redisson.getLock("myLock");
			lock.tryLock(60, TimeUnit.SECONDS);
			System.out.println("lock");
			lock.unlock();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
