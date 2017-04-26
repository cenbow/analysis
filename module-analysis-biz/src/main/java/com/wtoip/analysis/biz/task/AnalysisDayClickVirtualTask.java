package com.wtoip.analysis.biz.task;

import java.util.Calendar;

import javax.annotation.Resource;

import com.wtoip.analysis.biz.task.BaseTask.RollBack;
import com.wtoip.analysis.biz.task.job.AnalysisDayClickVirtualJob;
import com.wtoip.analysis.biz.task.job.AnalysisDayJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
public class AnalysisDayClickVirtualTask extends BaseTask{

	@Resource
	private AnalysisDayClickVirtualJob analysisDayClickVirtualJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.CALCULATED_EVENT_DAY_VIRTUAL,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				analysisDayClickVirtualJob.execute(day);
			}
		});
	}
}
