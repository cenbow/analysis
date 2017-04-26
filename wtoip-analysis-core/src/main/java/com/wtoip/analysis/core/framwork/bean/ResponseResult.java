package com.wtoip.analysis.core.framwork.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月30日
 */
public class ResponseResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误码(200:成功;其他为失败错误码)
	 */
	private Integer code;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * data
	 */
	private Object data;
	
	/**
	 * new
	 * @return
	 */
	public static ResponseResult newInstance(){
		return new ResponseResult();
	}

	/**
	 * 成功
	 * @return
	 */
	public ResponseResult success(){
		this.code = 200;
		return this;
	}
	
	/**
	 * 失败
	 * @return
	 */
	public ResponseResult error(Integer code){
		this.code = code;
		return this;
	}
	
	/**
	 * @return
	 */
	public ResponseResult message(String message){
		this.message = message;
		return this;
	}
	
	/**
	 * set data
	 * @return
	 */
	public ResponseResult data(Object data){
		this.data = data;
		return this;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
