package com.wtoip.analysis.biz.dao.impl;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.wtoip.analysis.biz.dao.AccessClickDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.AccessClick;

/** 
 */
@Repository("accessClickDao")
public class AccessClickDaoImpl extends BaseDao<AccessClick> implements AccessClickDao{
	
	private Logger log = LoggerFactory.getLogger(AccessClickDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see com.wtoip.analysis.biz.dao.AccessClickDao#analysisEventDayByDate(java.lang.String)
	 */
	@Override
	public void analysisEventDayByDate(String createDate) {
		
		log.info("analysisEventDayByDate:createDate={}",createDate);
		
		Query query=new Query();
		query.addCriteria(Criteria.where("createDate").is(createDate));
		
		StringBuilder mapFunction = new StringBuilder();
		mapFunction.append("function(){");
		mapFunction.append("emit({createDate: this.createDate,app: this.app,memberId: this.memberId,mallId: this.mallId,event: this.event},");
		mapFunction.append("{cookie: this.cookie,ip: this.ip})");
		mapFunction.append("}");
		
		StringBuilder reduceFunction = new StringBuilder();
		reduceFunction.append("function(key, values){");
		reduceFunction.append("reduced = {pv: 0,ip: 0,uvMap: {},ipMap: {}};");
		reduceFunction.append("uvMap = {};");
		reduceFunction.append("ipMap = {};");
		reduceFunction.append("values.forEach(function (val) {");
		reduceFunction.append("if (val.cookie) {");
		reduceFunction.append("reduced.pv += 1;");
		reduceFunction.append("uvkey = val.cookie + '_' + val.ip;");
		reduceFunction.append("uvMap[uvkey] = 1;");
		reduceFunction.append("ipMap[val.ip] = 1;");
		reduceFunction.append("} else {");
		reduceFunction.append("reduced.pv += val.pv;");
		reduceFunction.append("for (var key in val.uvMap) {");
		reduceFunction.append("uvMap[key] = 1;");
		reduceFunction.append("}");
		reduceFunction.append("for (var key in val.ipMap) {");
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
		finalizeFunction.append("reduced = {pv: 0,uv: 0,ip: 0};");
		finalizeFunction.append("reduced.pv = value.pv;");
		finalizeFunction.append("reduced.uv = Object.keys(value.uvMap).length;");
		finalizeFunction.append("reduced.ip = Object.keys(value.ipMap).length;");
		finalizeFunction.append("return reduced;");
		finalizeFunction.append("}");
		finalizeFunction.append("reduced = {pv: 1,uv: 1,ip: 1};");
		finalizeFunction.append("return reduced;");
		finalizeFunction.append("}");
		
		log.info("map function:" + mapFunction.toString());
		log.info("reduce function:" + reduceFunction.toString());
		
		MapReduceOptions mapReduceOptions = new MapReduceOptions().outputTypeMerge().outputCollection(CollectionName.EVENT_DAY_CLICK).finalizeFunction(finalizeFunction.toString());
		
		mongoTemplate.mapReduce(query, CollectionName.ACCESS_CLICK, mapFunction.toString(), reduceFunction.toString(), mapReduceOptions, entityClass);

	}


}
