package com.wtoip.analysis.biz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.wtoip.analysis.biz.bean.OrderTradeDayAdapter;
import com.wtoip.analysis.biz.converter.OrderTradeDayConverter;
import com.wtoip.analysis.biz.dao.OrderTradeDayDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.OrderTradeDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Repository("orderTradeDayDao")
public class OrderTradeDayDaoImpl extends BaseDao<OrderTradeDay> implements OrderTradeDayDao {

	private Logger log = LoggerFactory.getLogger(CalculatedDayDaoImpl.class);
	
	@Resource
	private OrderTradeDayConverter orderTradeDayConverter;
	
	@Override
	public void analysisOrderTradeDay(String createDate) {
		log.info("analysisOrderTradeDay:createDate={}",createDate);
		
		Query query=new Query();
		query.addCriteria(Criteria.where("payDate").is(createDate));
		
		StringBuilder mapFunction = new StringBuilder();
		mapFunction.append("function() {");
		mapFunction.append("data = this;");
		mapFunction.append("data.details.forEach(function (val) {");
		mapFunction.append("if(data.status=='03'||data.status=='04'||data.status=='05'){");
		mapFunction.append("emit({createDate:data.createDate,app:data.app,memberId:data.memberId,mallId:data.mallId,tradeId:val.tradeId,tradeName:val.tradeName},");
		mapFunction.append("{qty:val.quantity})");
		mapFunction.append("}");
		mapFunction.append("});");
		mapFunction.append("}");
		
		StringBuilder reduceFunction = new StringBuilder();
		reduceFunction.append("function(key, values){");
		reduceFunction.append("reduced = {qty:0};");
		reduceFunction.append("values.forEach(function (val) {");
		reduceFunction.append("reduced.qty += val.qty;");
		reduceFunction.append("});");
		reduceFunction.append("return reduced;");
		reduceFunction.append("}");
		
		log.info("map function:" + mapFunction.toString());
		log.info("reduce function:" + reduceFunction.toString());
		
		MapReduceOptions mapReduceOptions = new MapReduceOptions().outputTypeMerge().outputCollection(CollectionName.ORDER_TRADE_DAY);
		
		mongoTemplate.mapReduce(query, CollectionName.ORDER, mapFunction.toString(), reduceFunction.toString(), mapReduceOptions, entityClass);

	}
	
	@Override
	public List<OrderTradeDay> findTopNDateRange(String startDate, String endDate, String app, String memberId,long n) {
		Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId);
		
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(criteria),
				Aggregation.group(Fields.from(Fields.field("app", "_id.app"),Fields.field("memberId", "_id.memberId"),Fields.field("mallId", "_id.mallId"),Fields.field("tradeId", "_id.tradeId"),Fields.field("tradeName", "_id.tradeName")))
				.sum("value.qty").as("qty"),
				Aggregation.sort(new Sort(Direction.DESC, "qty")),
				Aggregation.limit(n)
		);
		
		AggregationResults<OrderTradeDayAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.ORDER_TRADE_DAY, OrderTradeDayAdapter.class);

		List<OrderTradeDayAdapter> list = results.getMappedResults();
		
		List<OrderTradeDay> dataList = new ArrayList<>(list.size());
		
		for(OrderTradeDayAdapter oda : list){
			OrderTradeDay orderTradeDay = orderTradeDayConverter.convert(oda);
			dataList.add(orderTradeDay);
		}
		
		return dataList;
	}
}
