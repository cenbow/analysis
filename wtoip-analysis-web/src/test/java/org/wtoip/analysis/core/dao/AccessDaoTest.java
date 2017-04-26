package org.wtoip.analysis.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtoip.analysis.biz.dao.AccessDao;
import com.wtoip.analysis.enums.Channel;
import com.wtoip.analysis.model.Access;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class AccessDaoTest {

	@Autowired
	private AccessDao accessDao;
	
	@Test
	public void test(){
		
	}
	
	private void insert(){
		String[] events = {"MAIN","HOME","GOOD","PAGE"};
		String[] userId = new String[100];
		for(int i=0;i<userId.length;i++){
			userId[i] = String.valueOf(10000+1);
		}
		String[] mallId = new String[100];
		for(int i=0;i<mallId.length;i++){
			mallId[i] = String.valueOf(10000+1);
		}
		String[] memberId = new String[50];
		for(int i=0;i<memberId.length;i++){
			memberId[i] = String.valueOf(10000+1);
		}
		String[] cookie = new String[300];
		for(int i=0;i<cookie.length;i++){
			cookie[i] = String.valueOf(10000+1);
		}
		String[] ip = new String[200];
		for(int i=1;i<ip.length;i++){
			ip[i] = "192.168.1." + (i+1);
		}
		
		String[] createDate = new String[30];
		for(int i=1;i<createDate.length;i++){
			createDate[i] = "2017-01-" + (i < 10 ? "0"+i : i);
		}
		String[] createTime = new String[24];
		for(int i=1;i<createTime.length;i++){
			createTime[i] = (i < 10 ? "0"+i : i) + ":57:27";
		}
		String[] createHour = new String[24];
		for(int i=1;i<createHour.length;i++){
			createHour[i] = String.valueOf(i);
		}
		
		
		for(int i=0;i<1000000;i++){
			System.out.println(i);
			
			Access access = new Access();
			access.setEvent(events[i%events.length]);
			access.setChannel(Channel.WEB);
			access.setUserId(userId[i%userId.length]);
			access.setMallId(mallId[i%mallId.length]);
			access.setMallName("圣标商标旗舰店");
			access.setMemberId(memberId[i%memberId.length]);
			access.setCookie(cookie[i%cookie.length]);
			access.setIp(ip[i%ip.length]);
			access.setStandingTime(5D);
			access.setCreateDate(createDate[i%createDate.length]);
			access.setCreateTime(createTime[i%createTime.length]);
			access.setCreateHour(createHour[i%createHour.length]);
			
			accessDao.insert(access);
		}
		
	}
}
