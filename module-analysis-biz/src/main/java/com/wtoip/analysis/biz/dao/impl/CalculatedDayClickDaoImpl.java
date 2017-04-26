package com.wtoip.analysis.biz.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.bean.EventDayClickAdapter;
import com.wtoip.analysis.biz.converter.EventDayClickConverter;
import com.wtoip.analysis.biz.dao.CalculatedDayClickDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.EventDayClick;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Repository("calculatedDayClickDao")
public class CalculatedDayClickDaoImpl extends BaseDao<EventDayClick> implements CalculatedDayClickDao{

	private Logger log = LoggerFactory.getLogger(CalculatedDayClickDaoImpl.class);
	
	@Resource
	private EventDayClickConverter eventDayClickConverter;
	
	/**
	 * 按时间范围查询事件PV,UV,IP
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 */
	@Override
	public List<EventDayClick> findMallEventDateRange(String startDate, String endDate, String app, String memberId,
			String mallId, String event) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId)
				.and("_id.event").is(event);
		
		Sort sort = new Sort(Direction.ASC, "_id.createDate");
		
		Query query=new Query();
		query.addCriteria(criteria).with(sort);
		
		return mongoTemplate.find(query, entityClass);
	}


	@Override
	public EventDayClick findMallEventDay(String date, String app, String memberId, String mallId, String event) {
		Criteria criteria = Criteria.where("_id.createDate").is(date)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId)
				.and("_id.event").is(event);
		
		Query query=new Query();
		query.addCriteria(criteria);
		
		return mongoTemplate.findOne(query, entityClass);
	}

	@Override
	public EventDayClick findMallEventDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId, String event) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId)
				.and("_id.event").is(event);
		
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(criteria),
				Aggregation.group(Fields.from(Fields.field("mallId", "_id.mallId"),Fields.field("event", "_id.event"))).sum("value.pv").as("pv").sum("value.rpv").as("rpv").sum("value.uv").as("uv").sum("value.ip").as("ip")
		);
		
		AggregationResults<EventDayClickAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.EVENT_DAY_CLICK, EventDayClickAdapter.class);
		
		EventDayClickAdapter eventDayClickAdapter = results.getUniqueMappedResult();
		if(eventDayClickAdapter == null){
			return null;
		}
		
		EventDayClick eventDayClick = eventDayClickConverter.convert(eventDayClickAdapter);
		eventDayClick.getId().setApp(app);
		eventDayClick.getId().setMemberId(memberId);
		return eventDayClick;
	}

}
