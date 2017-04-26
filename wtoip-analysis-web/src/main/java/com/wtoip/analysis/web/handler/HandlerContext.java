package com.wtoip.analysis.web.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public abstract class HandlerContext<T> implements BeanFactoryAware{
	
	private Logger log = LoggerFactory.getLogger(HandlerContext.class);
	
	private BeanFactory beanFactory;

	private List<Handler<T>> handlerList = new ArrayList<>();

	/**
	 * 
	 * @param handler
	 */
	public void registeHandler(Handler<T> handler){
		handlerList.add(handler);
	}
	
	/**
	 * 
	 * @param clazz
	 */
	public void registeHandler(Class<? extends Handler<T>> clazz){
		Handler<T> handler = beanFactory.getBean(clazz);
		handlerList.add(handler);
	}
	
	public void handle(T t){
		log.debug("handle:"+t);
		for(Handler<T> handler : handlerList){
			if(handler.supports(t)){
				try{
					handler.handle(t);
				}catch(Exception e){
					log.error(e.getMessage(),e);
				}
			}
		}
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
}
