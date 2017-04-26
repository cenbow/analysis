package com.wtoip.analysis.core.framwork.job;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public interface Job<T> {

	/**
	 * 
	 * @param t
	 */
	void execute(T t) throws Exception;
	
}
