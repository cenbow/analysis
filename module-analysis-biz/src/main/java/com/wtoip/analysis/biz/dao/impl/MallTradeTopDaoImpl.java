package com.wtoip.analysis.biz.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.MallTradeTopDao;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.MallTradeTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Repository("mallTradeTopDao")
public class MallTradeTopDaoImpl extends BaseDao<MallTradeTop> implements MallTradeTopDao{

	
	@Override
	public List<MallTradeTop> findSortMallTradeTop(String startDate, String endDate, String industryCode1,
			String industryCode2) {
		Criteria criteria = Criteria.where("_id.startDate").is(startDate)
				.and("_id.endDate").is(endDate)
				.and("_id.industryCode1").is(industryCode1)
				.and("_id.industryCode2").is(industryCode2);
		
		Sort sort = new Sort(Direction.DESC, "totalScore");
		
		Query query=new Query();
		query.addCriteria(criteria).with(sort).limit(20000);
		
		return mongoTemplate.find(query, entityClass);
	}

	@Override
	public List<MallTradeTop> findLastTwoData(String app, String memberId) {
		Criteria criteria = Criteria.where("_id.app").is(app)
				.and("_id.memberId").is(memberId);
		
		Query query=new Query();
		query.addCriteria(criteria);
		query.limit(2);
		
		Sort sort = new Sort(Direction.DESC, "_id.endDate");
		query.with(sort);
		
		return mongoTemplate.find(query, entityClass);
	}

}
