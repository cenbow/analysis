package org.wtoip.analysis.core.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.service.EventService;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml","classpath:spring-cache.xml"  ,"classpath:spring-mongodb.xml"})
public class EventServiceTest {

	@Resource
	private EventService eventService;
	
	@Test
	public void test(){
		findAll();
	}
	
	public void findAll(){
		eventService.findAll();
		eventService.findAll();
		eventService.findAll();
	}
}
