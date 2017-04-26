package com.wtoip.analysis.core.framwork.bean;

import java.io.Serializable;
import java.util.List;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
public class PageResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Page page;
	/**
	 * 结果集
	 */
	private List<T> data;
	
	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public PageResult<T> setPage(Page page) {
		this.page = page;
		return this;
	}
	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public PageResult<T> setData(List<T> data) {
		this.data = data;
		return this;
	}
	
	@Override
	public String toString() {
		return "PageResult [page=" + page + ", data=" + data + "]";
	}
}
