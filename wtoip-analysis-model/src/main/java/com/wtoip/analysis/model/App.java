package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;


/** 
 *  @Description:app
 *	@author wanghongwei
 *  @date:   2017年3月21日
 */
@Document(collection = "app")
public class App implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private String id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "App [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
}
