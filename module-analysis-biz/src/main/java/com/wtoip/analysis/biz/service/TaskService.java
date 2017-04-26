package com.wtoip.analysis.biz.service;

import com.wtoip.analysis.core.framwork.service.Service;
import com.wtoip.analysis.enums.TaskType;
import com.wtoip.analysis.model.Task;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface TaskService extends Service<Task>{
	/**
	 * 根据任务类型和执行周期查找
	 * @param type
	 * @param period
	 * @return
	 */
	Task findByTypeAndPeriod(TaskType type,String period);
}
