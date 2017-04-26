package com.wtoip.analysis.biz.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.TaskDao;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.enums.TaskType;
import com.wtoip.analysis.model.Task;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Repository("taskDao")
public class TaskDaoImpl extends BaseDao<Task> implements TaskDao{

	
	@Override
	public Task findByTypeAndPeriod(TaskType type, String period) {
		Query query=new Query();
		query.addCriteria(Criteria.where("type").is(type));
		query.addCriteria(Criteria.where("period").is(period));
		
		return mongoTemplate.findOne(query, entityClass);
	}

}
