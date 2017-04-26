package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Document(collection = "order_day")
public class OrderDay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * _id
	 */
	private _Id id;
	/**
	 * value
	 */
	private _Value value;
	
	public static class _Id implements Serializable{

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
		 * 行业编码（1级）
		 */
		private String industryCode1;
		/**
		 * 行业编码（2级）
		 */
		private String industryCode2;
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
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "_Id [createDate=" + createDate + ", app=" + app + ", memberId=" + memberId + ", mallId=" + mallId
					+ ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + "]";
		}
	}
	
	public static class _Value implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
			return "_Value [tradeFee=" + tradeFee + ", commissionFee=" + commissionFee + ", totalFee=" + totalFee
					+ ", totalQty=" + totalQty + ", validQty=" + validQty + ", invalidQty=" + invalidQty + "]";
		}
	}

	/**
	 * @return the id
	 */
	public _Id getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(_Id id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public _Value getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(_Value value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "OrderDay [id=" + id + ", value=" + value + "]";
	}
}
