package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.MallPvTopService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class MallPvTopJob implements Job<String[]>{

	@Resource
	private MallPvTopService mallPvTopService;
	
	@Override
	public void execute(String[] t) throws Exception {
		String startDate = t[0];
		String endDate = t[1];
		mallPvTopService.analysisMallPvTopByDateRange(startDate, endDate);
	}

}
