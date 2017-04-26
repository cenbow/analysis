package com.wtoip.analysis.biz.task.job;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.OrderService;
import com.wtoip.analysis.biz.service.OrderTradeDayService;
import com.wtoip.analysis.core.util.DateUtil;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Component
public class AnalysisOrderLast30DaysJob {
	
	Logger logger = LoggerFactory.getLogger(AnalysisOrderLast30DaysJob.class);
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderTradeDayService orderTradeDayService;
	
	public void execute() throws Exception{
		Date now = new Date();
		Date lastDate = DateUtil.addDays(now,-31);
		
		while(lastDate.compareTo(now) < 0){
			String createDate = DateUtil.getDay(lastDate);
			logger.info("CalculatedLast30Days,date="+createDate);
			try{
				orderService.analysisOrderDayByDate(createDate);
				orderTradeDayService.analysisOrderTradeDay(createDate);
			}catch(Exception e){
				e.printStackTrace();
			}
			lastDate = DateUtil.addDays(lastDate, 1);
		}
		
	}
}
