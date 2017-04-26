package org.wtoip.analysis.core.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wtoip.analysis.biz.dao.OrderDao;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.core.util.JSR303Util;
import com.wtoip.analysis.core.util.RandomUtil;
import com.wtoip.analysis.core.util.UUIDUtil;
import com.wtoip.analysis.model.Order;
import com.wtoip.analysis.model.Order.OrderDetail;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" ,"classpath:spring-mongodb.xml"})
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void test(){
		/*Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);*/
		//insert();
		//orderDao.analysisOrderDayByDate(day);
		//orderDao.analysisOrderDayByDate("2017-04-22");
		insert();
		orderDao.analysisOrderDayByDate("2017-04-07");
	}
	
	private void insert(){
		String[] userId = new String[100];
		for(int i=0;i<userId.length;i++){
			userId[i] = String.valueOf(10000+i);
		}
		String[] orderid = new String[10000];
		for(int i=0;i<orderid.length;i++){
			orderid[i] = String.valueOf(150420100+i);
		}
		String[] memberId = new String[50];
		for(int i=0;i<memberId.length;i++){
			memberId[i] = String.valueOf(10000+i);
		}
		String[] ordertype = new String[2];
		for(int i=0;i<ordertype.length;i++){
			ordertype[i] = String.valueOf("0"+(i+1));
		}
		
		String[] createDate = new String[30];
		for(int i=1;i<createDate.length;i++){
			createDate[i] = "2017-04-" + (i < 10 ? "0"+i : i);
		}
		String[] createTime = new String[24];
		for(int i=1;i<createTime.length;i++){
			createTime[i] = (i < 10 ? "0"+i : i) + ":57:27";
		}
		String[] status = new String[6];
		for(int i=0;i<status.length;i++){
			status[i] = String.valueOf("0"+(i+1));
		}
		List<OrderDetail> details = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			OrderDetail orderd = new OrderDetail();
			orderd.setTradeId(orderid[i%orderid.length]);
			orderd.setTradeName("商品"+i);
			orderd.setTradeType(ordertype[i%2]);
			Random random=new Random();
			orderd.setQuantity((double)random.nextInt(10));
			details.add(orderd);
		}
//		String[] createHour = new String[24];
//		for(int i=1;i<createHour.length;i++){
//			createHour[i] = String.valueOf(i);
//		}
		
		for(int i=1;i<400;i++){
			System.out.println(i);
			
			Order order = new Order();
			order.setApp("MALL");
			order.setId(UUIDUtil.getUUID());
			order.setUserId(userId[i%userId.length]);
			order.setIndustryCode1("0");
			order.setIndustryCode2("0");
//			order.setMemberId(memberId[i%memberId.length]);
			order.setMemberId("162278");
			order.setMallId("0");
			order.setStatus(status[i%status.length]);
			order.setOrderType(ordertype[i%2]);
			order.setTradeFee(Double.valueOf(RandomUtil.getRandom(10000)));
			order.setCommissionFee(Double.valueOf(RandomUtil.getRandom(10000)));
			order.setTotalFee(order.getTradeFee()+order.getCommissionFee());
//			order.setCreateDate(createDate[i%createDate.length]);
			order.setCreateDate("2017-04-07");
			order.setUpdateDate("2017-04-07");
			order.setPayDate("2017-04-07");
			order.setCancelDate("2017-04-07");
			order.setCompleteDate("2017-04-07");
			order.setDetails(details);
			JSR303Util.validate(order);
			
			orderDao.insert(order);
		}
		
		
//		for(int i=1;i<1000;i++){
//			System.out.println(i);
//			
//			Order order = new Order();
//			order.setApp("ORDER");
//			order.setId(orderid[i]);
//			order.setUserId(userId[i%userId.length]);
//			order.setIndustryCode1("0");
//			order.setIndustryCode2("0");
////			order.setMemberId(memberId[i%memberId.length]);
//			order.setMemberId("10000");
//			order.setMallId("0");
//			order.setStatus(status[i%status.length]);
//			order.setOrderType(ordertype[i%2]);
//			order.setTradeFee(new Random().nextDouble());
//			order.setCommissionFee(new Random().nextDouble());
//			order.setTotalFee(new Random().nextDouble());
////			order.setCreateDate(createDate[i%createDate.length]);
//			order.setCreateDate(createDate[i%createDate.length]);
//			order.setUpdataDate(createDate[i%createDate.length]);
//			order.setCreateTime(createTime[i%createTime.length]);
//			order.setPayDate(createDate[i%createDate.length]);
//			order.setCancelDate(createDate[i%createDate.length]);
//			order.setCompleteDate(createDate[i%createDate.length]);
//			order.setCompleteTime(createTime[i%createTime.length]);
//			order.setDetails(details);
//			
//			JSR303Util.validate(order);
//			
//			orderDao.insert(order);
//		}
		
	}
}
