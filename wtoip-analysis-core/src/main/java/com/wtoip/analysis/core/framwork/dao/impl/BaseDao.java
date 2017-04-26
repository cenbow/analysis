package com.wtoip.analysis.core.framwork.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.dao.Dao;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public abstract class BaseDao<E> implements Dao<E> {

	@Resource
	protected MongoTemplate mongoTemplate;
	
	protected Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		ParameterizedType pt = (ParameterizedType)(getClass().getGenericSuperclass());
		entityClass = (Class<E>)pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(E entity) {
		mongoTemplate.insert(entity);
	}

	@Override
	public void update(E entity) {
		mongoTemplate.save(entity);
	}

	@Override
	public void deleteById(Object id) {
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		mongoTemplate.remove(query, entityClass);
	}

	@Override
	public E findById(Object id) {
		return mongoTemplate.findById(id, entityClass);
	}
	
	@Override
	public PageResult<E> findAllPage(Page page,String[] propName, Object[] propValue){
		Query query=new Query();
		if(propName!=null && propValue!=null){
			for(int i=0; i<propName.length; i++){
				query.addCriteria(Criteria.where(propName[i]).is(propValue[i]));
			}
		}
		//是否计算总数
		if(page.getCount()){
			Long totalResult=mongoTemplate.count(query, entityClass);
			page.setTotalResult(totalResult);
		}
		
		String[] sortArray = page.getSort();
		String[] orderArray = page.getOrder();
		if(sortArray!=null && sortArray!=null){
			List<Order> orders = new ArrayList<>();
			for(int i=0; i<sortArray.length; i++){
				orders.add(new Order(Direction.valueOf(orderArray[i]),sortArray[i]));
			}
			Sort sort=new Sort(orders);
			query.with(sort);
		}
		
		query.skip(page.getCurrentResult()).limit(page.getRows());
		
		List<E> dataList=mongoTemplate.find(query, entityClass);
		
		return new PageResult<E>().setPage(page).setData(dataList);
		
	}
}
