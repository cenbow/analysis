package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description:以店铺维度按天统计PV,UV,IP
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
@Document(collection = "calculated_day")
public class CalculatedDay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * _id
	 */
	protected _Id id;
	/**
	 * value
	 */
	protected _Value value;
	

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
		return "CalculatedDay [id=" + id + ", value=" + value + "]";
	}

	/**
	 *  
	 *  @Description:
	 *	@author wanghongwei
	 *  @date:  2017年3月21日
	 */
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
			return "_Id [createDate=" + createDate + ", app=" + app + ", memberId=" + memberId + ", mallId=" + mallId
					+ ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + "]";
		}
		
	}
	
	/**
	 * 
	 *  @Description:
	 *	@author wanghongwei
	 *  @date:  2017年3月21日
	 */
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
		
		@Override
		public String toString() {
			return "_Value [pv=" + pv + ", rpv=" + rpv + ", uv=" + uv + ", ip=" + ip + ", jo=" + jo + ", st=" + st
					+ "]";
		}
	}
	
}
