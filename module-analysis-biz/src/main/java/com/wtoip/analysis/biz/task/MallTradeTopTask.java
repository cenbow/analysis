package com.wtoip.analysis.biz.task;

import java.util.Calendar;
import javax.annotation.Resource;
import com.wtoip.analysis.biz.task.job.MallTradeTopJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description 店铺交易排行
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public class MallTradeTopTask extends BaseTask{

	@Resource
	private MallTradeTopJob mallTradeTopJob;
	
	public void execute(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		final String endDate = DateUtil.getDay(calendar);
		
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		
		final String startDate = DateUtil.getDay(calendar);
		
		String period = startDate + "-" + endDate;
		
		String[] params = new String[]{startDate,endDate};
		
		_execute(TaskType.MALL_TRADE_TOP,period,params,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				mallTradeTopJob.execute(params);
			}
		});
	}
}
