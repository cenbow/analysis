package com.wtoip.analysis.biz.task.job;


import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.AccessClickService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description 按天统计店铺-事件
 *	@author 木四点
 *  @date   2017年3月27日
 */
@Component
public class AnalysisDayClickJob implements Job<String>{

	@Resource
	private AccessClickService accessClickService;

	
	@Override
	public void execute(String t) throws Exception {
		// TODO Auto-generated method stub
		accessClickService.analysisEventDayByDate(t);
	}

}
