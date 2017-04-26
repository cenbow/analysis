package org.wtoip.analysis.core.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.dao.CalculatedDayDao;
import com.wtoip.analysis.model.CalculatedDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月1日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class CalculatedDayDaoTest {

	@Resource
	private CalculatedDayDao calculatedDayDao;
	
	@Test
	public void test(){
		findMallDay();
		findMallDateRange();
	}
	
	public void findMallDay(){
		String date = "2017-03-201";
		String app = "MALL";
		String memberId = "121144";
		String mallId = "3396";
		
		CalculatedDay calculatedDay = calculatedDayDao.findMallDay(date, app, memberId, mallId);
		
		System.out.println(calculatedDay);
	}
	
	public void findMallDateRange(){
		String startDate = "2017-03-20";
		String endDate = "2017-03-31";
		String app = "MALL";
		String memberId = "121144";
		String mallId = "3396";
		
		List<CalculatedDay> dataList = calculatedDayDao.findMallDateRange(startDate, endDate, app, memberId, mallId);
		
		System.out.println(dataList.size());
	}
}
