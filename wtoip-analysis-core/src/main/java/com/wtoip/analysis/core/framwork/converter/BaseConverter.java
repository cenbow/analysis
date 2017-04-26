package com.wtoip.analysis.core.framwork.converter;

import java.lang.reflect.ParameterizedType;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */
public abstract class BaseConverter<S,T> implements Converter<S,T>{

	protected Class<S> clzzs;
	
	protected Class<T> clzzt;
	
	@SuppressWarnings("unchecked")
	public BaseConverter(){
		ParameterizedType pt = (ParameterizedType)(getClass().getGenericSuperclass());
		clzzs = (Class<S>)pt.getActualTypeArguments()[0];
		clzzt = (Class<T>)pt.getActualTypeArguments()[1];
	}
	
	
	public boolean supports(Class<?> clzzs,Class<?> clazzt){
		return this.clzzs.equals(clzzs) && this.clzzt.equals(clazzt);
	}

}
