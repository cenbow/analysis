package com.wtoip.analysis.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.TaskDao;
import com.wtoip.analysis.biz.service.TaskService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.enums.TaskType;
import com.wtoip.analysis.model.Task;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Service("taskService")
public class TaskServiceImpl extends BaseService<Task> implements TaskService{

	@Resource
	private TaskDao taskDao;
	
	@Override
	protected Dao<Task> getDao() {
		return taskDao;
	}

	@Override
	public Task findByTypeAndPeriod(TaskType type, String period) {
		return taskDao.findByTypeAndPeriod(type, period);
	}

}
