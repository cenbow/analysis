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
import com.wtoip.analysis.biz.converter.MallDesignTopConverter;
import com.wtoip.analysis.biz.dao.MallDesignTopDao;
import com.wtoip.analysis.biz.util.Constants.CollectionName;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.MallDesignTop;
import com.wtoip.analysis.model.ShopDesign;
/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Repository("mallDesignTopDao")
public class MallDesignTopDaoImpl extends BaseDao<MallDesignTop> implements MallDesignTopDao{

	private Logger log = LoggerFactory.getLogger(MallDesignTopDaoImpl.class);
	
	@Resource
	private MallDesignTopConverter mallDesignTopConverter;
	
	@Override
	public void analysisMallDesignTopByDay(String createDate) {
		log.info("analysisMallDesignTopByDay:createDate={}",createDate);
		
		Criteria industryCriteria = Criteria.where("_id.createDate").is(createDate);
		//先统计行业分类
		Aggregation industryCodeAggregation = Aggregation.newAggregation(
				Aggregation.match(industryCriteria),
				Aggregation.group(Fields.from(Fields.field("industryCode1", "_id.industryCode1"),Fields.field("industryCode2", "_id.industryCode2")))
		);
		AggregationResults<IndustryCodeAdapter> industryCodeResults = mongoTemplate.aggregate(industryCodeAggregation, CollectionName.SHOP_DESIGN, IndustryCodeAdapter.class);
		List<IndustryCodeAdapter> industryCodeList = industryCodeResults.getMappedResults();
		
		//按行业统计排行
		for(IndustryCodeAdapter industryCode : industryCodeList){
			Criteria criteria = Criteria.where("_id.createDate").is(createDate)
					.and("_id.industryCode1").is(industryCode.getIndustryCode1())
					.and("_id.industryCode2").is(industryCode.getIndustryCode2());
			Sort sort = new Sort(Direction.DESC, "totalScore");
			Query query=new Query();
			query.addCriteria(criteria).with(sort).limit(50000);
			
			List<ShopDesign> list = mongoTemplate.find(query, ShopDesign.class);
			
			Double rank = 1D;
			Date createTime = new Date();
			for(ShopDesign shopDesign : list){
				MallDesignTop mallDesignTop = mallDesignTopConverter.convert(shopDesign);
				mallDesignTop.setCreateTime(createTime);
				mallDesignTop.setRank(rank);
				
				update(mallDesignTop);
				rank++;
			}
			
		}
	}

	@Override
	public List<MallDesignTop> findLastTwoData(String app, String memberId, String mallId) {
		Criteria criteria = Criteria.where("_id.app").is(app)
				.and("_id.memberId").is(memberId)
				.and("_id.mallId").is(mallId);
		
		Query query=new Query();
		query.addCriteria(criteria);
		query.limit(2);
		
		Sort sort = new Sort(Direction.DESC, "_id.createDate");
		query.with(sort);
		
		return mongoTemplate.find(query, entityClass);
	}

}
