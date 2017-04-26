package com.wtoip.analysis.biz.dao.impl;

import java.util.Date;
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

import com.wtoip.analysis.biz.bean.IndustryCodeAdapter;
import com.wtoip.analysis.biz.bean.MallPvTopAdapter;
import com.wtoip.analysis.biz.converter.MallPvTopConverter;
import com.wtoip.analysis.biz.dao.MallPvTopDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
@Repository("mallPvTopDao")
public class MallPvTopDaoImpl extends BaseDao<MallPvTop> implements MallPvTopDao{

	private Logger log = LoggerFactory.getLogger(MallPvTopDaoImpl.class);
	
	@Resource
	private MallPvTopConverter mallPvTopConverter;
	
	@Override
	public void analysisMallPvTopByDateRange(String startDate, String endDate) {
		log.info("analysisMallPvTopByDateRange:startDate={},endDate={}",startDate,endDate);
		
		Criteria industryCriteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate);
		
		//先统计行业分类
		Aggregation industryCodeAggregation = Aggregation.newAggregation(
				Aggregation.match(industryCriteria),
				Aggregation.group(Fields.from(Fields.field("industryCode1", "_id.industryCode1"),Fields.field("industryCode2", "_id.industryCode2")))
		);
		AggregationResults<IndustryCodeAdapter> industryCodeResults = mongoTemplate.aggregate(industryCodeAggregation, CollectionName.CALCULATED_DAY_VIRTUAL, IndustryCodeAdapter.class);
		List<IndustryCodeAdapter> industryCodeList = industryCodeResults.getMappedResults();
		
		//按行业统计排行
		for(IndustryCodeAdapter industryCode : industryCodeList){
			if(industryCode.getIndustryCode1()==null || industryCode.getIndustryCode2()==null){
				continue;
			}
			Criteria criteria = Criteria.where("_id.createDate").gte(startDate).lte(endDate)
					.and("_id.industryCode1").is(industryCode.getIndustryCode1())
					.and("_id.industryCode2").is(industryCode.getIndustryCode2());
			
			Aggregation aggregation = Aggregation.newAggregation(
					Aggregation.match(criteria),
					Aggregation.group(Fields.from(Fields.field("app", "_id.app"),Fields.field("memberId", "_id.memberId"),Fields.field("mallId", "_id.mallId"))).sum("value.pv").as("pv"),
					Aggregation.sort(new Sort(Direction.DESC, "pv")),
					Aggregation.limit(20000)
			);
			
			AggregationResults<MallPvTopAdapter> results = mongoTemplate.aggregate(aggregation, CollectionName.CALCULATED_DAY_VIRTUAL, MallPvTopAdapter.class);
			List<MallPvTopAdapter> list = results.getMappedResults();
			
			Double rank = 1D;
			Date createTime = new Date();
			for(MallPvTopAdapter mallPvTopAdapter : list){
				MallPvTop mallPvTop = mallPvTopConverter.convert(mallPvTopAdapter);
				mallPvTop.getId().setIndustryCode1(industryCode.getIndustryCode1());
				mallPvTop.getId().setIndustryCode2(industryCode.getIndustryCode2());
				mallPvTop.getId().setStartDate(startDate);
				mallPvTop.getId().setEndDate(endDate);
				mallPvTop.setCreateTime(createTime);
				mallPvTop.setRank(rank);

				update(mallPvTop);
				rank++;
			}
		}
	}

	
	@Override
	public List<MallPvTop> findLastTwoData(String app, String memberId, String mallId) {
		Criteria criteria = Criteria.where("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		
		Query query=new Query();
		query.addCriteria(criteria);
		query.limit(2);
		
		Sort sort = new Sort(Direction.DESC, "_id.endDate");
		query.with(sort);
		
		return mongoTemplate.find(query, entityClass);
	}

}
