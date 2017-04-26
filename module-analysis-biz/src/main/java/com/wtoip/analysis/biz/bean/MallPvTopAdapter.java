package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
public class MallPvTopAdapter  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * app
	 */
	private String app;
	/**
	 * 会员id
	 */
	private String memberId;
	/**
	 * 店铺
	 */
	private String mallId;
	/**
	 * 总pv
	 */
	private Double pv;
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
	
	@Override
	public String toString() {
		return "MallPvTopAdapter [app=" + app + ", memberId=" + memberId + ", mallId=" + mallId + ", pv=" + pv + "]";
	}
	
}
