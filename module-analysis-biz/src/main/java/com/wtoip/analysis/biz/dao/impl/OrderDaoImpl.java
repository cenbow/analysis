package com.wtoip.analysis.biz.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.OrderDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.Order;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
@Repository("orderDao")
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao{
	
	private Logger log = LoggerFactory.getLogger(OrderDaoImpl.class);

	@Override
	public void analysisOrderDayByDate(String createDate) {
		
		log.info("analysisOrderDayByDate={}",createDate);
		
		Query query=new Query();
		query.addCriteria(Criteria.where("updateDate").is(createDate));
		
		StringBuilder mapFunction = new StringBuilder();
		mapFunction.append("function(){");
		mapFunction.append("emit({createDate:this.updateDate,app:this.app,memberId:this.memberId,mallId:this.mallId,industryCode1:this.industryCode1,industryCode2:this.industryCode2},");
		mapFunction.append("{tradeFee: this.tradeFee,commissionFee: this.commissionFee,totalFee: this.totalFee,status:this.status,updateDate:this.updateDate,createDate:this.createDate,payDate:this.payDate,cancelDate:this.cancelDate})");
		mapFunction.append("}");
		
		StringBuilder reduceFunction = new StringBuilder();
		reduceFunction.append("function(key, values){");
		reduceFunction.append("reduced = {tradeFee:0,totalQty:0,validQty:0,invalidQty:0,commissionFee:0,totalFee:0};");
		reduceFunction.append("values.forEach(function (val) {");
		reduceFunction.append("if(val.status){");
		reduceFunction.append("if (val.createDate==val.updateDate) {");
		reduceFunction.append("reduced.totalQty+=1; ");
		reduceFunction.append("}if(val.payDate==val.updateDate && (val.status=='03'||val.status=='04'||val.status=='05')){");
		reduceFunction.append("reduced.tradeFee=val.tradeFee;");
		reduceFunction.append("reduced.validQty+=1;");
		reduceFunction.append("reduced.totalFee=val.totalFee;");
		reduceFunction.append("reduced.commissionFee=val.commissionFee;");
		reduceFunction.append("}if(val.cancelDate==val.updateDate && val.status=='06'){");
		reduceFunction.append("reduced.invalidQty+=1;");
		reduceFunction.append("}");
		reduceFunction.append("}else{");
		reduceFunction.append("reduced.totalQty+=val.totalQty;");
		reduceFunction.append("reduced.validQty+=val.validQty;");
		reduceFunction.append("reduced.tradeFee+=val.tradeFee;");
		reduceFunction.append("reduced.commissionFee+=val.commissionFee;");
		reduceFunction.append("reduced.totalFee+=val.totalFee;");
		reduceFunction.append("reduced.invalidQty+=val.invalidQty;");
		reduceFunction.append("}");
		reduceFunction.append("});");
		reduceFunction.append("return reduced;");
		reduceFunction.append("}");
		
		StringBuilder finalizeFunction = new StringBuilder();
		finalizeFunction.append("function(key, val){");
		finalizeFunction.append("if(val.status){");
		finalizeFunction.append("reduced = {tradeFee:0,totalQty:0,validQty:0,invalidQty:0,commissionFee:0,totalFee:0};");
		finalizeFunction.append("if(val.status){");
		finalizeFunction.append("if (val.createDate==val.updateDate) {");
		finalizeFunction.append("reduced.totalQty+=1;");
		finalizeFunction.append("}if(val.payDate==val.updateDate){");
		finalizeFunction.append("reduced.tradeFee=val.tradeFee;");
		finalizeFunction.append("reduced.validQty=1;");
		finalizeFunction.append("reduced.totalFee=val.totalFee;");
		finalizeFunction.append("reduced.commissionFee=val.commissionFee;");
		finalizeFunction.append("}if(val.cancelDate==val.updateDate && val.status=='06'){");
		finalizeFunction.append("reduced.invalidQty=1;");
		finalizeFunction.append("}");
		finalizeFunction.append("}");
		finalizeFunction.append("return reduced;");
		finalizeFunction.append("}");
		finalizeFunction.append("return val;");
		finalizeFunction.append("}");
		
		
		log.info("map function:" + mapFunction.toString());
		log.info("reduce function:" + reduceFunction.toString());
		log.info("finalize function:" + finalizeFunction.toString());
		
		MapReduceOptions mapReduceOptions = new MapReduceOptions().outputTypeMerge().outputCollection(CollectionName.ORDER_DAY).finalizeFunction(finalizeFunction.toString());
		
		mongoTemplate.mapReduce(query, CollectionName.ORDER, mapFunction.toString(), reduceFunction.toString(), mapReduceOptions, entityClass);

	}

}
