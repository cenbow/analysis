package com.wtoip.analysis.core.framwork.converter;

/** 
 *  @Description:数据转换接口
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
public interface Converter<S,T> {

	/**
	 * 
	 * @param clzzs
	 * @param clazzt
	 * @return
	 */
	boolean supports(Class<?> clzzs,Class<?> clazzt);
	
	/**
	 * 数据转换接口
	 * @param s
	 * @return
	 */
	T convert(S s);
	
}
