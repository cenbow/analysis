package com.wtoip.analysis.core.util;

import org.springframework.beans.BeanUtils;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月30日
 */
public class BeanUtil {

	/**
	 * @param source
	 * @param targetClass
	 * @return
	 */
	public static <T> T copyProperties(Object source, Class<T> targetClass){
		try {
			T t = targetClass.newInstance();
			copyProperties(source, t);
			return t;
		} catch (InstantiationException | IllegalAccessException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public static void copyProperties(Object source, Object target){
		BeanUtils.copyProperties(source, target);
	}
	
}
