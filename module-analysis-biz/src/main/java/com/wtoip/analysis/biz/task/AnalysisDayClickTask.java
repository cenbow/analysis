package com.wtoip.analysis.biz.task;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.AccessClickService;
import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.biz.task.BaseTask.RollBack;
import com.wtoip.analysis.biz.task.job.AnalysisDayClickJob;
import com.wtoip.analysis.core.framwork.job.Job;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description 按天统计店铺-事件
 *	@author 木四点
 *  @date   2017年3月27日
 */
public class AnalysisDayClickTask extends BaseTask{

	@Resource
	private AnalysisDayClickJob analysisDayClickJob;

	public void execute() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.CALCULATED_EVENT_DAY,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				analysisDayClickJob.execute(day);
			}
		});
	}
}
