package org.wtoip.analysis.core.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.service.AccessService;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class AccessServiceTest {

	@Resource
	private AccessService accessService;
	
	@Test
	public void test(){
		Long start = System.currentTimeMillis();
		//analysisEventDayByDate();
		Long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	
	
}
