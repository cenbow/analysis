package com.wtoip.analysis.biz.task;

import java.util.Calendar;

import javax.annotation.Resource;

import com.wtoip.analysis.biz.task.job.AnalysisDayVirtualJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
public class AnalysisDayVirtualTask extends BaseTask{

	@Resource
	private AnalysisDayVirtualJob analysisDayVirtualJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.CALCULATED_DAY_VIRTUAL,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				analysisDayVirtualJob.execute(day);
			}
		});
	}
}
