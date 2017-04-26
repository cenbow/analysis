package com.wtoip.analysis.web.handler;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface Handler<T> {

	/**
	 * 
	 * @param event
	 * @return
	 */
	boolean supports(T t);
	
	/**
	 * 数据处理
	 * @param t
	 */
	void handle(T t) throws Exception;
}
