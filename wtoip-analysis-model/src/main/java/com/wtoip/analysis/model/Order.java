package com.wtoip.analysis.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月19日
 */
@Document(collection = "order")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * app
	 */
	@NotEmpty
	private String app;
	/**
	 * 订单id
	 */
	@NotEmpty
	private String id;
	/**
	 * 用户
	 */
	private String userId;
	/**
	 * 店铺
	 */
	@NotEmpty
	private String mallId;
	/**
	 * 会员id
	 */
	@NotEmpty
	private String memberId;
	/**
	 * 行业编码（1级）
	 */
	@NotEmpty
	private String industryCode1;
	/**
	 * 行业编码（2级）
	 */
	@NotEmpty
	private String industryCode2;
	/**
	 * 订单类型(01订单 10资源商服务商品订单)
	 */
	@NotEmpty
	private String orderType;
	/**
	 *  交易金额
	 */
	@NotNull
	private Double tradeFee;
	/**
	 * 佣金
	 */
	private Double commissionFee;
	/**
	 * 总金额
	 */
	@NotNull
	private Double totalFee;
	/**
	 * 订单状态(01-生成订单  02-待付款 03-已付款 04-已过户 05-确认收货待评价 06-取消订单)
	 */
	@NotEmpty
	private String status;
	/**
	 * 订单详情
	 */
	@NotNull
	@Valid
	private List<OrderDetail> details;
	
	/**
	 * 同步时间：2017-01-04
	 */
	@NotEmpty
	private String updateDate;
	/**
	 * 创建时间：2017-01-04
	 */
	@NotEmpty
	private String createDate;
	/**
	 * 创建时间（时间维度）：13:57:27
	 */
	private String createTime;
	/**
	 * 支付时间：2017-01-04
	 */
	private String payDate;
	/**
	 * 支付时间（时间维度）：13:57:27
	 */
	private String payTime;
	/**
	 * 取消时间：2017-01-04
	 */
	private String cancelDate;
	/**
	 * 取消时间（时间维度）：13:57:27
	 */
	private String cancelTime;
	/**
	 * 完成时间：2017-01-04
	 */
	private String completeDate;
	/**
	 * 完成时间（时间维度）：13:57:27
	 */
	private String completeTime;
	
	
	public static class OrderDetail implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * 交易id
		 */
		@NotEmpty
		private String tradeId;
		/**
		 * 交易名称
		 */
		@NotEmpty
		private String tradeName;
		/**
		 * 交易类型
		 */
		private String tradeType;
		/**
		 * 交易数量
		 */
		@NotNull
		private Double quantity;
	
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
		/**
		 * @return the tradeType
		 */
		public String getTradeType() {
			return tradeType;
		}
		/**
		 * @param tradeType the tradeType to set
		 */
		public void setTradeType(String tradeType) {
			this.tradeType = tradeType;
		}
		/**
		 * @return the quantity
		 */
		public Double getQuantity() {
			return quantity;
		}
		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}
		
		@Override
		public String toString() {
			return "OrderDetail [tradeId=" + tradeId + ", tradeName=" + tradeName + ", tradeType=" + tradeType
					+ ", quantity=" + quantity + "]";
		}
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
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the payDate
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	/**
	 * @return the payTime
	 */
	public String getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the completeDate
	 */
	public String getCompleteDate() {
		return completeDate;
	}
	/**
	 * @param completeDate the completeDate to set
	 */
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	/**
	 * @return the completeTime
	 */
	public String getCompleteTime() {
		return completeTime;
	}
	/**
	 * @param completeTime the completeTime to set
	 */
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
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
	 * @return the details
	 */
	public List<OrderDetail> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
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
	 * @return the cancelDate
	 */
	public String getCancelDate() {
		return cancelDate;
	}
	/**
	 * @param cancelDate the cancelDate to set
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	/**
	 * @return the cancelTime
	 */
	public String getCancelTime() {
		return cancelTime;
	}
	/**
	 * @param cancelTime the cancelTime to set
	 */
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Order [app=" + app + ", id=" + id + ", userId=" + userId + ", mallId=" + mallId + ", memberId="
				+ memberId + ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + ", orderType="
				+ orderType + ", tradeFee=" + tradeFee + ", commissionFee=" + commissionFee + ", totalFee=" + totalFee
				+ ", status=" + status + ", details=" + details + ", updateDate=" + updateDate + ", createDate="
				+ createDate + ", createTime=" + createTime + ", payDate=" + payDate + ", payTime=" + payTime
				+ ", cancelDate=" + cancelDate + ", cancelTime=" + cancelTime + ", completeDate=" + completeDate
				+ ", completeTime=" + completeTime + "]";
	}
}
