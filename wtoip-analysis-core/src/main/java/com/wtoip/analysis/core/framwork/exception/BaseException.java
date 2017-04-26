package com.wtoip.analysis.core.framwork.exception;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月17日
 */
public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(){
		
	}

	public BaseException(String errMsg){
		super(errMsg);
	}
	
	public BaseException(String errMsg,Throwable throwable){
		super(errMsg,throwable);
	}

}
