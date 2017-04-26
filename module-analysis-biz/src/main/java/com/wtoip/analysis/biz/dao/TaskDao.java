package com.wtoip.analysis.biz.dao;

import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.enums.TaskType;
import com.wtoip.analysis.model.Task;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface TaskDao extends Dao<Task>{

	/**
	 * 根据任务类型和执行周期查找
	 * @param type
	 * @param period
	 * @return
	 */
	Task findByTypeAndPeriod(TaskType type,String period);
}
