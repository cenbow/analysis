package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
public class CalculatedDayVirtualAdapter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * app
	 */
	private String app;
	/**
	 * 商家id
	 */
	private String memberId;
	/**
	 * 店铺id
	 */
	private String mallId;
	/**
	 * 行业编码（1级）
	 */
	private String industryCode1;
	/**
	 * 行业编码（2级）
	 */
	private String industryCode2;
	/**
	 * pv
	 */
	private Double pv;
	/**
	 * 刷新器产生的pv
	 */
	private Double rpv;
	/**
	 * uv
	 */
	private Double uv;
	/**
	 * ip
	 */
	private Double ip;
	/**
	 * 跳出数
	 */
	private Double jo;
	/**
	 * 停留时间
	 */
	private Double st;
	/**
	 * @return the app
	 */
	public String getApp() {
		return app;
	}
	/**
	 * @param app the app to set
	 */
	public void setApp(String app) {
		this.app = app;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the mallId
	 */
	public String getMallId() {
		return mallId;
	}
	/**
	 * @param mallId the mallId to set
	 */
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}
	/**
	 * @return the pv
	 */
	public Double getPv() {
		return pv;
	}
	/**
	 * @param pv the pv to set
	 */
	public void setPv(Double pv) {
		this.pv = pv;
	}
	/**
	 * @return the rpv
	 */
	public Double getRpv() {
		return rpv;
	}
	/**
	 * @param rpv the rpv to set
	 */
	public void setRpv(Double rpv) {
		this.rpv = rpv;
	}
	/**
	 * @return the uv
	 */
	public Double getUv() {
		return uv;
	}
	/**
	 * @param uv the uv to set
	 */
	public void setUv(Double uv) {
		this.uv = uv;
	}
	/**
	 * @return the ip
	 */
	public Double getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(Double ip) {
		this.ip = ip;
	}
	/**
	 * @return the jo
	 */
	public Double getJo() {
		return jo;
	}
	/**
	 * @param jo the jo to set
	 */
	public void setJo(Double jo) {
		this.jo = jo;
	}
	/**
	 * @return the st
	 */
	public Double getSt() {
		return st;
	}
	/**
	 * @param st the st to set
	 */
	public void setSt(Double st) {
		this.st = st;
	}
	
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
		return "CalculatedDayVirtualAdapter [app=" + app + ", memberId=" + memberId + ", mallId=" + mallId
				+ ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + ", pv=" + pv + ", rpv="
				+ rpv + ", uv=" + uv + ", ip=" + ip + ", jo=" + jo + ", st=" + st + "]";
	}
}
