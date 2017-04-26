package com.wtoip.analysis.biz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.bean.CalculatedDayVirtualAdapter;
import com.wtoip.analysis.biz.converter.CalculatedDayVirtualConverter;
import com.wtoip.analysis.biz.dao.CalculatedDayVirtualDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.CalculatedDayVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Repository("calculatedDayVirtualDao")
public class CalculatedDayVirtualDaoImpl extends BaseDao<CalculatedDayVirtual> implements CalculatedDayVirtualDao{

	@Resource
	private CalculatedDayVirtualConverter calculatedDayVirtualConverter;
	
	@Override
	public CalculatedDayVirtual findMallDay(String date, String app, String memberId, String mallId) {
		Criteria criteria = Criteria.where("_id.createDate").is(date)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		Query query=new Query();
		query.addCriteria(criteria);
		
		return mongoTemplate.findOne(query, entityClass);
	}

	@Override
	public List<CalculatedDayVirtual> findMallDateRange(String startDate, String endDate, String app, String memberId,
			String mallId) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		
		Sort sort = new Sort(Direction.ASC, "_id.createDate");
		
		Query query=new Query();
		query.addCriteria(criteria).with(sort);
		
		return mongoTemplate.find(query, entityClass);
	}

	
	@Override
	public CalculatedDayVirtual findMallDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(criteria),
				Aggregation.group(Fields.from(Fields.field("memberId", "_id.memberId"),Fields.field("mallId", "_id.mallId"))).sum("value.pv").as("pv").sum("value.rpv").as("rpv").sum("value.uv").as("uv").sum("value.ip").as("ip")
		);
		
		AggregationResults<CalculatedDayVirtualAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.CALCULATED_DAY_VIRTUAL, CalculatedDayVirtualAdapter.class);
		
		CalculatedDayVirtualAdapter calculatedDayVirtualAdapter = results.getUniqueMappedResult();
		if(calculatedDayVirtualAdapter == null){
			return null;
		}

		CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualConverter.convert(calculatedDayVirtualAdapter);
		calculatedDayVirtual.getId().setApp(app);
		return calculatedDayVirtual;
	}

	@Override
	public PageResult<CalculatedDayVirtual> findMallAggregationDateRange(Page page,String startDate, String endDate) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate);
		
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(criteria),
				Aggregation.group(Fields.from(Fields.field("app", "_id.app"),Fields.field("memberId", "_id.memberId"),Fields.field("mallId", "_id.mallId"),Fields.field("industryCode1", "_id.industryCode1"),Fields.field("industryCode2", "_id.industryCode2"))).sum("value.pv").as("pv").sum("value.rpv").as("rpv").sum("value.uv").as("uv").sum("value.ip").as("ip"),
				Aggregation.skip(Long.valueOf(page.getCurrentResult())),
				Aggregation.limit(page.getRows())
		);
		
		AggregationResults<CalculatedDayVirtualAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.CALCULATED_DAY_VIRTUAL, CalculatedDayVirtualAdapter.class);
		
		List<CalculatedDayVirtualAdapter> mappedResults = results.getMappedResults();
		
		List<CalculatedDayVirtual> dataList = new ArrayList<>(mappedResults.size());
		
		for(CalculatedDayVirtualAdapter cva : mappedResults){
			CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualConverter.convert(cva);
			dataList.add(calculatedDayVirtual);
		}
		PageResult<CalculatedDayVirtual> result = new PageResult<>();
		result.setPage(page);
		result.setData(dataList);
		return result;
	}

}
