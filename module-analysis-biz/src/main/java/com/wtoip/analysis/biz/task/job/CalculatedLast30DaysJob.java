package com.wtoip.analysis.biz.task.job;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wtoip.analysis.core.util.DateUtil;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月11日
 */
@Component
public class CalculatedLast30DaysJob {
	
	Logger logger = LoggerFactory.getLogger(CalculatedLast30DaysJob.class);

	@Resource
	private AnalysisDayJob analysisDayJob;
	
	@Resource
	private AnalysisDayVirtualJob analysisDayVirtualJob;
	
	
	public void execute() throws Exception{
		Date now = new Date();
		Date lastDate = DateUtil.addDays(now,-30);
		
		while(lastDate.compareTo(now) <= 0){
			String createDate = DateUtil.getDay(lastDate);
			logger.info("CalculatedLast30Days,date="+createDate);
			try{
				analysisDayJob.execute(createDate);
				analysisDayVirtualJob.execute(createDate);
			}catch(Exception e){
				e.printStackTrace();
			}
			lastDate = DateUtil.addDays(lastDate, 1);
		}
		
	}
	
}
