package org.wtoip.analysis.core.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wtoip.analysis.biz.service.OrderTradeDayService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml","classpath:spring-cache.xml"  ,"classpath:spring-mongodb.xml"})
public class OrderTradeDayServiceTest {

	@Resource
	private OrderTradeDayService orderTradeDayService;
	
	@Test
	public void test(){
		try{
			orderTradeDayService.analysisOrderTradeDay("2017-04-20");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
