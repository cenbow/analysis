package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.OrderService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description 按天统计店铺-事件
 *	@author 木四点
 *  @date   2017年3月27日
 */
@Component
public class AnalysisDayOrderJob implements Job<String>{

	@Resource
	private OrderService orderService;

	
	@Override
	public void execute(String t) throws Exception {
		orderService.analysisOrderDayByDate(t);
	}
}
