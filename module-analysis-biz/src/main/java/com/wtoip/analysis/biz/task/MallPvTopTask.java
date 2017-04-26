package com.wtoip.analysis.biz.task;

import java.util.Calendar;
import javax.annotation.Resource;
import com.wtoip.analysis.biz.task.job.MallPvTopJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
public class MallPvTopTask extends BaseTask{

	@Resource
	private MallPvTopJob mallPvTopJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String endDate = DateUtil.getDay(calendar);
		
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		
		final String startDate = DateUtil.getDay(calendar);
		
		String period = startDate + "-" + endDate;
		
		String[] params = new String[]{startDate,endDate};
		
		_execute(TaskType.MALL_PV_TOP,period,params,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				mallPvTopJob.execute(params);
			}
		});
	}
}
