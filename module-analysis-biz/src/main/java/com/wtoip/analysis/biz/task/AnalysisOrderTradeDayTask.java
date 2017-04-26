package com.wtoip.analysis.biz.task;

import java.util.Calendar;
import javax.annotation.Resource;
import com.wtoip.analysis.biz.task.job.AnalysisOrderTradeDayJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
public class AnalysisOrderTradeDayTask extends BaseTask{

	@Resource
	private AnalysisOrderTradeDayJob analysisOrderTradeDayJob;
	
	public void execute() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.CALCULATED_ORDER_TRADE_DAY,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				analysisOrderTradeDayJob.execute(day);
			}
		});
	}
}
