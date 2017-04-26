package com.wtoip.analysis.biz.bean;

import java.io.Serializable;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
public class OrderDayAdapter implements Serializable{

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
	 *  交易金额
	 */
	private Double tradeFee;
	/**
	 * 佣金
	 */
	private Double commissionFee;
	/**
	 * 总金额
	 */
	private Double totalFee;
	/**
	 * 订单量
	 */
	private Double totalQty;
	/**
	 * 有效订单量
	 */
	private Double validQty;
	/**
	 * 无效订单量
	 */
	private Double invalidQty;
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
	 * @return the tradeFee
	 */
	public Double getTradeFee() {
		return tradeFee;
	}
	/**
	 * @param tradeFee the tradeFee to set
	 */
	public void setTradeFee(Double tradeFee) {
		this.tradeFee = tradeFee;
	}
	/**
	 * @return the commissionFee
	 */
	public Double getCommissionFee() {
		return commissionFee;
	}
	/**
	 * @param commissionFee the commissionFee to set
	 */
	public void setCommissionFee(Double commissionFee) {
		this.commissionFee = commissionFee;
	}
	/**
	 * @return the totalFee
	 */
	public Double getTotalFee() {
		return totalFee;
	}
	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * @return the totalQty
	 */
	public Double getTotalQty() {
		return totalQty;
	}
	/**
	 * @param totalQty the totalQty to set
	 */
	public void setTotalQty(Double totalQty) {
		this.totalQty = totalQty;
	}
	/**
	 * @return the validQty
	 */
	public Double getValidQty() {
		return validQty;
	}
	/**
	 * @param validQty the validQty to set
	 */
	public void setValidQty(Double validQty) {
		this.validQty = validQty;
	}
	/**
	 * @return the invalidQty
	 */
	public Double getInvalidQty() {
		return invalidQty;
	}
	/**
	 * @param invalidQty the invalidQty to set
	 */
	public void setInvalidQty(Double invalidQty) {
		this.invalidQty = invalidQty;
	}
	
	@Override
	public String toString() {
		return "OrderDayAdapter [app=" + app + ", memberId=" + memberId + ", tradeFee=" + tradeFee + ", commissionFee="
				+ commissionFee + ", totalFee=" + totalFee + ", totalQty=" + totalQty + ", validQty=" + validQty
				+ ", invalidQty=" + invalidQty + "]";
	}
}
