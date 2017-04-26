package com.wtoip.analysis.biz.dao.impl;

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
import com.wtoip.analysis.biz.bean.OrderDayAdapter;
import com.wtoip.analysis.biz.converter.OrderDayConverter;
import com.wtoip.analysis.biz.dao.OrderDayDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.OrderDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Repository("orderDayDao")
public class OrderDayDaoImpl extends BaseDao<OrderDay> implements OrderDayDao{

	@Resource
	private OrderDayConverter orderDayConverter;
	
	@Override
	public List<OrderDay> findOrderDateRange(String startDate, String endDate, String app, String memberId) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId);
		
		Sort sort = new Sort(Direction.ASC, "_id.createDate");
		Query query=new Query();
		query.addCriteria(criteria).with(sort);
		return mongoTemplate.find(query, entityClass);
	}

	
	@Override
	public OrderDay findOrderDateRangeSum(String startDate, String endDate, String app, String memberId) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId);
		
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(criteria),
				Aggregation.group(Fields.from(Fields.field("app", "_id.app"),Fields.field("memberId", "_id.memberId"))).sum("value.tradeFee").as("tradeFee").sum("value.commissionFee").as("commissionFee").sum("value.totalFee").as("totalFee")
				.sum("value.totalQty").as("totalQty").sum("value.validQty").as("validQty").sum("value.invalidQty").as("invalidQty")
		);
		
		AggregationResults<OrderDayAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.ORDER_DAY, OrderDayAdapter.class);
		
		OrderDayAdapter orderDayAdapter = results.getUniqueMappedResult();
		if(orderDayAdapter == null){
			return null;
		}

		OrderDay orderDay = orderDayConverter.convert(orderDayAdapter);
		return orderDay;
	}

}
