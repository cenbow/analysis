package com.wtoip.analysis.biz.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.wtoip.analysis.biz.converter.CalculatedDayConverter;
import com.wtoip.analysis.biz.dao.CalculatedDayDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.CalculatedDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月1日
 */
@Repository("calculatedDayDao")
public class CalculatedDayDaoImpl extends BaseDao<CalculatedDay> implements CalculatedDayDao{

	private Logger log = LoggerFactory.getLogger(CalculatedDayDaoImpl.class);
	
	@Resource
	protected MongoTemplate mongoTemplate;
	
	@Resource
	private CalculatedDayConverter calculatedDayConverter;
	
	@Override
	public void analysisDayByDate(String createDate) {
		log.info("analysisDayByDate:createDate={}",createDate);
		
		Query query=new Query();
		query.addCriteria(Criteria.where("createDate").is(createDate));
		
		StringBuilder mapFunction = new StringBuilder();
		mapFunction.append("function() {");
		mapFunction.append("emit({createDate:this.createDate,app:this.app,memberId:this.memberId,mallId:this.mallId,industryCode1:this.industryCode1,industryCode2:this.industryCode2},");
		mapFunction.append("{cookie:this.cookie,ip:this.ip,source:this.source})");
		mapFunction.append("}");
		
		StringBuilder reduceFunction = new StringBuilder();
		reduceFunction.append("function(key, values){");
		reduceFunction.append("reduced = {pv:0,rpv:0,uvMap:{},ipMap:{}};");
		reduceFunction.append("uvMap = {};");
		reduceFunction.append("ipMap = {};");
		reduceFunction.append("values.forEach(function(val){");
		reduceFunction.append("if(val.cookie){");
		reduceFunction.append("reduced.pv += 1;");
		reduceFunction.append("if(val.source=='refresher'){");
		reduceFunction.append("reduced.rpv += 1;");
		reduceFunction.append("}");
		reduceFunction.append("uvkey = val.cookie+'_'+val.ip;");
		reduceFunction.append("uvMap[uvkey] = 1;");
		reduceFunction.append("ipMap[val.ip] = 1;");
		reduceFunction.append("}else{");
		reduceFunction.append("reduced.pv += val.pv;");
		reduceFunction.append("reduced.rpv += val.rpv;");
		reduceFunction.append("for(var key in val.uvMap){");
		reduceFunction.append("uvMap[key] = 1;");
		reduceFunction.append("}");
		reduceFunction.append("for(var key in val.ipMap){");
		reduceFunction.append("ipMap[key] = 1;");
		reduceFunction.append("}");
		reduceFunction.append("}");
		reduceFunction.append("});");
		reduceFunction.append("reduced.uvMap = uvMap;");
		reduceFunction.append("reduced.ipMap = ipMap;");
		reduceFunction.append("return reduced;");
		reduceFunction.append("}");
		
		StringBuilder finalizeFunction = new StringBuilder();
		finalizeFunction.append("function(key, value){");
		finalizeFunction.append("if(value.pv){");
		finalizeFunction.append("reduced = {pv:0,rpv:0,uv:0,ip:0};");
		finalizeFunction.append("reduced.pv = value.pv;");
		finalizeFunction.append("reduced.rpv = value.rpv;");
		finalizeFunction.append("reduced.uv = Object.keys(value.uvMap).length;");
		finalizeFunction.append("reduced.ip = Object.keys(value.ipMap).length;");
		finalizeFunction.append("return reduced;");
		finalizeFunction.append("}");
		finalizeFunction.append("reduced = {pv:1,rpv:0,uv:1,ip:1};");
		finalizeFunction.append("if(value.source=='refresher'){");
		finalizeFunction.append("reduced.rpv += 1;");
		finalizeFunction.append("}");
		finalizeFunction.append("return reduced;");
		finalizeFunction.append("}");
		
		log.info("map function:" + mapFunction.toString());
		log.info("reduce function:" + reduceFunction.toString());
		
		MapReduceOptions mapReduceOptions = new MapReduceOptions().outputTypeMerge().outputCollection(CollectionName.CALCULATE_DAY).finalizeFunction(finalizeFunction.toString());
		
		mongoTemplate.mapReduce(query, CollectionName.ACCESS, mapFunction.toString(), reduceFunction.toString(), mapReduceOptions, entityClass);
	}
	
	@Override
	public CalculatedDay findMallDay(String date, String app, String memberId, String mallId) {
		Criteria criteria = Criteria.where("_id.createDate").is(date)
				.and("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		Query query=new Query();
		query.addCriteria(criteria);
		
		return mongoTemplate.findOne(query, entityClass);
	}

	@Override
	public List<CalculatedDay> findMallDateRange(String startDate, String endDate, String app, String memberId,
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

}
