package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description:以店铺-页面(事件)维度按天统计PV,UV,IP,ST(停留时间)
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
@Document(collection = "event_day_click")
public class EventDayClick implements Serializable{
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
		return "CalculatedEventDay [id=" + id + ", value=" + value + "]";
	}

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
		 * 店铺id
		 */
		private String mallId;
		/**
		 * 事件
		 */
		private String event;
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
		
		@Override
		public String toString() {
			return "Id [createDate=" + createDate + ", app=" + app + ", memberId=" + memberId + ", mallId=" + mallId
					+ ", event=" + event + "]";
		}
	}
	
	public static class _Value implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
		
		
		@Override
		public String toString() {
			return "Value [pv=" + pv + ", uv=" + uv + ", ip=" + ip + "]";
		}
	}

}
