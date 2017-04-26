package org.wtoip.analysis.core;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.util.Constants.CacheName;
import com.wtoip.analysis.core.framwork.cache.LocalCache;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-cache.xml" ,"classpath:spring-mongodb.xml"})
public class LocalCacheTest {

	@Resource
	private LocalCache localCache;
	
	@Test
	public void test(){
		Event event = new Event();
		event.setCode("MAIN");
		event.setName("店铺首页");
		
		localCache.put(CacheName.CACHE_NAMESPACE, CacheName.PAGE_CACHE_NAME, "main", event);
		
		Event eventCache = localCache.get(CacheName.CACHE_NAMESPACE, CacheName.PAGE_CACHE_NAME, "main");
		
		System.out.println(eventCache.getCode()+"="+eventCache.getName());
	}
}
