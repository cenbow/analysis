package org.wtoip.analysis.core.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wtoip.analysis.biz.dao.EventDao;
import com.wtoip.analysis.model.Event;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class EventDaoTest {

	@Resource
	private EventDao eventDao;
	
	@Test
	public void test(){
		insert();
	}
	
	public void insert(){
		Event event = new Event();
		event.setCode("MAIN");
		event.setName("首页");
		
		eventDao.insert(event);
	}
	
}
