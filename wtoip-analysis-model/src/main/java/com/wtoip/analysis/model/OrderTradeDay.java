package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description 热销
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Document(collection = "order_trade_day")
public class OrderTradeDay implements Serializable{

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
		 * 交易id
		 */
		private String tradeId;
		/**
		 * 交易名称
		 */
		private String tradeName;
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
			return "_Id [createDate=" + createDate + ", app=" + app + ", memberId=" + memberId + ", mallId=" + mallId
					+ ", tradeId=" + tradeId + ", tradeName=" + tradeName + "]";
		}
	}
	
	public static class _Value implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * 销量
		 */
		private Double qty;
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
	
		@Override
		public String toString() {
			return "_Value [qty=" + qty + "]";
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
		return "OrderTradeDay [id=" + id + ", value=" + value + "]";
	}
}
