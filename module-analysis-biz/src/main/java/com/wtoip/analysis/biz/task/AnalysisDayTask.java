package com.wtoip.analysis.biz.task;

import java.util.Calendar;
import javax.annotation.Resource;

import com.wtoip.analysis.biz.task.job.AnalysisDayJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description:每天执行店铺维度的日统计
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
public class AnalysisDayTask extends BaseTask{
	
	@Resource
	private AnalysisDayJob analysisDayJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.CALCULATED_DAY,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				analysisDayJob.execute(day);
			}
		});
	}
	
}
