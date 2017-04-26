package com.wtoip.analysis.core.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.wtoip.analysis.core.framwork.exception.BaseCodeException;
import com.wtoip.analysis.core.util.Constants.ErrorCode;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public class JSR303Util{
	
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	/**
	 * 
	 * @param object
	 * @param groups
	 */
	public static <T> void validate(T object, Class<?>... groups){
		Validator validator = factory.getValidator(); 
		Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
		if(violations!=null){
			for(ConstraintViolation<T> violation: violations) { 
				throw new BaseCodeException(ErrorCode.VALIDATE_ERROR,violation.getPropertyPath()+violation.getMessage());
			}
		}
	}
}