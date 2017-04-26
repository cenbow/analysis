package org.wtoip.analysis.core.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.service.AccessClickService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class AccessClickServiceTest {

	@Resource
	private AccessClickService accessClickService;
	
	@Test
	public void test(){
		accessClickService.analysisEventDayByDate("2017-04-11");
	}
	
}
