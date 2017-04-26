package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
public class IndustryCodeAdapter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 行业编码（1级）
	 */
	private String industryCode1;
	/**
	 * 行业编码（2级）
	 */
	private String industryCode2;
	/**
	 * @return the industryCode1
	 */
	public String getIndustryCode1() {
		return industryCode1;
	}
	/**
	 * @param industryCode1 the industryCode1 to set
	 */
	public void setIndustryCode1(String industryCode1) {
		this.industryCode1 = industryCode1;
	}
	/**
	 * @return the industryCode2
	 */
	public String getIndustryCode2() {
		return industryCode2;
	}
	/**
	 * @param industryCode2 the industryCode2 to set
	 */
	public void setIndustryCode2(String industryCode2) {
		this.industryCode2 = industryCode2;
	}
	
	@Override
	public String toString() {
		return "IndustryCodeAdapter [industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + "]";
	}
}
