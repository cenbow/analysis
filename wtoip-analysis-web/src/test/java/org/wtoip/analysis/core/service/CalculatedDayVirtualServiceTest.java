package org.wtoip.analysis.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.biz.service.CalculatedDayVirtualService;
import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class CalculatedDayVirtualServiceTest {

	@Resource
	private CalculatedDayVirtualService calculatedDayVirtualService;
	
	@Test
	public void test(){
		//findMallDay();
		try {
			findMallDateRange();
			findMallDateRangeSum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void findMallDay(){
		String createDate = "2017-04-05";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		
		CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualService.findMallDay(createDate, app, memberId, mallId,null,null);
		
		System.out.println(calculatedDayVirtual);
	}
	
	private void findMallDateRange() throws Exception{
		String startDate = "2017-04-01";
		String endDate = "2017-04-06";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		
		List<CalculatedDayVirtual> list = calculatedDayVirtualService.findMallDateRange(startDate, endDate, app, memberId, mallId,null,null);
		
		for(CalculatedDayVirtual calculatedDayVirtual : list){
			System.out.println(calculatedDayVirtual);
		}
	}
	
	private void findMallDateRangeSum(){
		String startDate = "2017-04-10";
		String endDate = "2017-04-10";
		String app = "MALL";
		String memberId = "138160";
		String mallId = "2292";
		CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualService.findMallDateRangeSum(startDate, endDate, app, memberId, mallId);
		
		System.out.println(calculatedDayVirtual);
	}
}
