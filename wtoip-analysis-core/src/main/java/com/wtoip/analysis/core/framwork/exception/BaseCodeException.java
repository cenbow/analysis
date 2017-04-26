package com.wtoip.analysis.core.framwork.exception;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月30日
 */
public class BaseCodeException extends BaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误码
	 */
	private Integer errcode;

	public BaseCodeException(Integer errcode, String errMsg) {
		super(errMsg);
		this.errcode = errcode;
	}
	
	public BaseCodeException(Integer errcode, String errMsg, Throwable throwable) {
		super(errMsg, throwable);
		this.errcode = errcode;
	}

	/**
	 * @return the errcode
	 */
	public Integer getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
}
