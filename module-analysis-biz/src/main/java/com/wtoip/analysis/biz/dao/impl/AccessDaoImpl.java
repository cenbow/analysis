package com.wtoip.analysis.biz.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.AccessDao;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.Access;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Repository("accessDao")
public class AccessDaoImpl extends BaseDao<Access> implements AccessDao{

	private Logger log = LoggerFactory.getLogger(AccessDaoImpl.class);
	
	@Override
	public Access findLastByCookieAndIp(String cookie, String ip) {
		Query query=new Query();
		query.addCriteria(Criteria.where("cookie").is(cookie));
		query.addCriteria(Criteria.where("ip").is(ip));
		
		Sort sort = new Sort(Direction.DESC, "timestamp");
		query.with(sort);
		
		return mongoTemplate.findOne(query, entityClass);
	}

}
