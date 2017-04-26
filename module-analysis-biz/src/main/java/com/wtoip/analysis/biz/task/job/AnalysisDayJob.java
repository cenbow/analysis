package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.CalculatedDayService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description:按天统计店铺
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
@Component
public class AnalysisDayJob implements Job<String>{

	@Resource
	private CalculatedDayService calculatedDayService;
	
	@Override
	public void execute(String t) throws Exception {
		calculatedDayService.analysisDayByDate(t);
	}
}
