package org.wtoip.analysis.core.util;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wtoip.analysis.core.framwork.lock.DLock;
import com.wtoip.analysis.core.framwork.lock.DLockFactory;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月17日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml" ,"classpath:spring-cache.xml"})
public class DisLockTest {

	@Resource
	private Redisson redisson;
	
	@Resource
	private DLockFactory dLockFactory;
	
	public static int num = 0;
	
	@Test
	public void test() throws InterruptedException{
		
		/*redisson.getBucket("lock_analysis_test").delete();
		for(int i=0;i<100;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						DLock lock = dLockFactory.getRedisLock("test");
						for(int i=0;i<100;i++){
							lock.tryLock(5, TimeUnit.SECONDS);
							num++;
							Thread.sleep(1l);
							System.out.println(num);
							lock.unlock();
						}
						System.out.println(num);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		Thread.sleep(100000000l);*/
		
		redisson.getBucket("RedisLock_test").delete();
		
		DLock lock = dLockFactory.getRedisLock("test",10,TimeUnit.SECONDS);
		/*Long start = System.currentTimeMillis();
		System.out.println(lock.tryLock(5, TimeUnit.SECONDS));
		Long t1 = System.currentTimeMillis();
		System.out.println(t1-start);
		
		System.out.println(lock.tryLock(5, TimeUnit.SECONDS));
		Long t2 = System.currentTimeMillis();
		System.out.println(t2-start);
		
		System.out.println(lock.tryLock(15, TimeUnit.SECONDS));
		Long t3 = System.currentTimeMillis();
		System.out.println(t3-start);
		lock.unlock();
		System.out.println(lock.tryLock(5, TimeUnit.SECONDS));
		Long t4 = System.currentTimeMillis();
		System.out.println(t4-start);*/
		
		Long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			System.out.println(lock.tryLock(5, TimeUnit.SECONDS));
			num++;
			lock.unlock();
		}
		System.out.println(num);
		Long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
		
	}
	
}
