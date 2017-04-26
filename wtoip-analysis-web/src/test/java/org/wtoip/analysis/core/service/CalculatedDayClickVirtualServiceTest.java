package org.wtoip.analysis.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.service.CalculatedDayClickVirtualService;
import com.wtoip.analysis.model.EventDayClickVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class CalculatedDayClickVirtualServiceTest {

	@Resource
	private CalculatedDayClickVirtualService calculatedDayClickVirtualService;
	
	@Test
	public void test(){
		//findMallEventDay();
		try {
			findMallEventDateRange();
			findMallEventDateRangeSum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void findMallEventDay(){
		String createDate = "2017-04-05";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		String event = "MAIN";
		 
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualService.findMallEventDay(createDate, app, memberId, mallId, event);
		
		System.out.println(eventDayClickVirtual);
	}
	
	private void findMallEventDateRange() throws Exception{
		String startDate = "2017-04-01";
		String endDate = "2017-04-06";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		String event = "MAIN";
		
		List<EventDayClickVirtual> list = calculatedDayClickVirtualService.findMallEventDateRange(startDate, endDate, app, memberId, mallId, event);
		
		for(EventDayClickVirtual eventDayClickVirtual : list){
			System.out.println(eventDayClickVirtual);
		}
	}
	
	private void findMallEventDateRangeSum() throws Exception{
		String startDate = "2017-04-01";
		String endDate = "2017-04-06";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		String event = "MAIN";
		
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualService.findMallEventDateRangeSum(startDate, endDate, app, memberId, mallId, event);

		System.out.println(eventDayClickVirtual);
	}
}
