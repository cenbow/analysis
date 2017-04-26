package com.wtoip.analysis.biz.task;

import java.util.Calendar;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtoip.analysis.biz.task.job.AnalysisOrderLast30DaysJob;
import com.wtoip.analysis.biz.task.job.CalculatedLast30DaysJob;
import com.wtoip.analysis.biz.task.job.MallDesignTopJob;
import com.wtoip.analysis.biz.task.job.MoveDataJob;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月1日
 */
public class OneTimeTask extends BaseTask{

	private Logger logger = LoggerFactory.getLogger(OneTimeTask.class);
	
	@Resource
	private MoveDataJob moveDataJob;
	
	@Resource
	private CalculatedLast30DaysJob calculatedLast30DaysJob;
	
	@Resource
	private AnalysisOrderLast30DaysJob analysisOrderLast30DaysJob;
	
	@Resource
	private MallDesignTopJob mallDesignTopJob;
	
	public void execute(){
		//String period = "01";
		String period = "02";
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		_execute(TaskType.ONE_TIME,period,null,true,new RollBack(){
			@Override
			public void rollBack() throws Exception {
				//一期
				/*logger.info("OneTimeTask:moveDataJob");
				moveDataJob.execute();
				logger.info("OneTimeTask:calculatedLast30Days");
				calculatedLast30DaysJob.execute();
				logger.info("OneTimeTask:mallDesignTopJob("+day+")");
				mallDesignTopJob.execute(day);*/
				
				//二期
				analysisOrderLast30DaysJob.execute();
			}
		});
	}
}
