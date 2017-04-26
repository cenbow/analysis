package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月23日
 */

public class CalculatedEventDayAdapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 时间
	 */
	private String createDate;
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
	 * 事件
	 */
	private String event;
	/**
	 * pv
	 */
	private Double pv;
	/**
	 * uv
	 */
	private Double uv;
	/**
	 * ip
	 */
	private Double ip;
	
	
	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
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
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
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

}
