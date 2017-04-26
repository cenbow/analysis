package com.wtoip.analysis.core.framwork.spring.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/** 
 *  @Description:缓存分页标记
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface PageCache {
	/**
	 * 缓存key
	 * @return
	 */
	String value() default "";
	/**
	 * 第一页数据是否从代理方法获取
	 * @return
	 */
	boolean loadPageOne() default true;
}
