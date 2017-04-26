package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
public class OrderTradeDayAdapter implements Serializable{
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
	 * 店铺
	 */
	private String mallId;
	/**
	 * 交易id
	 */
	private String tradeId;
	/**
	 * 交易名称
	 */
	private String tradeName;
	/**
	 * 销量
	 */
	private Double qty;
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
	 * @return the qty
	 */
	public Double getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(Double qty) {
		this.qty = qty;
	}
	
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
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the tradeName
	 */
	public String getTradeName() {
		return tradeName;
	}
	/**
	 * @param tradeName the tradeName to set
	 */
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	@Override
	public String toString() {
		return "OrderTradeDayAdapter [createDate=" + createDate + ", app=" + app + ", memberId=" + memberId
				+ ", mallId=" + mallId + ", tradeId=" + tradeId + ", tradeName=" + tradeName + ", qty=" + qty + "]";
	}
}
