package com.wtoip.analysis.biz.task;

import java.util.Calendar;
import javax.annotation.Resource;
import com.wtoip.analysis.biz.task.job.MallDesignTopJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
public class MallDesignTopTask extends BaseTask{

	@Resource
	private MallDesignTopJob mallDesignTopJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String day = DateUtil.getDay(calendar);
		
		String period = day;
		
		_execute(TaskType.MALL_DESIGN_TOP,period,day,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				mallDesignTopJob.execute(day);
			}
		});
	}
}
