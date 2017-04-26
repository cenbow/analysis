package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.OrderTradeDayService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Component
public class AnalysisOrderTradeDayJob implements Job<String>{

	@Resource
	private OrderTradeDayService orderTradeDayService;

	@Override
	public void execute(String t) throws Exception {
		orderTradeDayService.analysisOrderTradeDay(t);
	}

}
