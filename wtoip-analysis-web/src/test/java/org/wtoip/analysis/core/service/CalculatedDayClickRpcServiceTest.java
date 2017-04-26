package org.wtoip.analysis.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.model.EventDayClick;
import com.wtoip.analysis.rpc.service.CalculatedDayClickRpcService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml" ,"classpath:spring-cache.xml"})
public class CalculatedDayClickRpcServiceTest {

	@Resource
	private CalculatedDayClickRpcService calculatedDayClickRpcService;
	
	@Test
	public void test() throws Exception{
		try{
			String startDate = "2017-04-13";
			String endDate = "2017-04-13";
			String app = "MALL";
			String memberId = "222";
			String mallId = "112";
			String event = "SHOP_COLLECTION_CLICK";
			
			List<EventDayClick> list = calculatedDayClickRpcService.findMallEventDateRange(startDate, endDate, app, memberId, mallId, event);
			
			System.out.println(list.size());

		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
}
