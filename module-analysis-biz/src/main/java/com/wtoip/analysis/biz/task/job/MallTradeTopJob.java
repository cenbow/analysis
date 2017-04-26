package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.MallTradeTopService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Component
public class MallTradeTopJob implements Job<String[]>{

	@Resource
	private MallTradeTopService mallTradeTopService;
	
	@Override
	public void execute(String[] t) throws Exception {
		String startDate = t[0];
		String endDate = t[1];
		
		mallTradeTopService.analysisMallTradeTopByDateRange(startDate, endDate);
	}

}
