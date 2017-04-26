package com.wtoip.analysis.core.framwork.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 *  @Description: 辅助缓存key,按照value顺序组装参数
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface ParameterValueKey{
	
	/**
	 * 
	 * @return
	 */
	public int value() default 0;
}
