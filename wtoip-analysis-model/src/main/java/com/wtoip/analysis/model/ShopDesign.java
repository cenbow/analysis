package com.wtoip.analysis.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description 店铺装修实力
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Document(collection = "shop_design")
public class ShopDesign implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * _id
	 */
	@NotNull
	@Valid
	private _Id id;
	/**
	 * 组件得分
	 */
	private Double moduleScore;
	/**
	 * 页面得分
	 */
	private Double pageScore;
	/**
	 * 总得分
	 */
	@NotNull
	private Double totalScore;
	
	public static class _Id implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * 时间
		 */
		@NotEmpty
		private String createDate;
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
		 * app
		 */
		@NotEmpty
		private String app;
		/**
		 * 会员id
		 */
		@NotEmpty
		private String memberId;
		/**
		 * 店铺
		 */
		@NotEmpty
		private String mallId;
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
		
		@Override
		public String toString() {
			return "_Id [app=" + app + ", memberId=" + memberId + ", mallId=" + mallId + ", industryCode1="
					+ industryCode1 + ", industryCode2=" + industryCode2 + ", createDate=" + createDate + "]";
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
	 * @return the moduleScore
	 */
	public Double getModuleScore() {
		return moduleScore;
	}

	/**
	 * @param moduleScore the moduleScore to set
	 */
	public void setModuleScore(Double moduleScore) {
		this.moduleScore = moduleScore;
	}

	/**
	 * @return the pageScore
	 */
	public Double getPageScore() {
		return pageScore;
	}

	/**
	 * @param pageScore the pageScore to set
	 */
	public void setPageScore(Double pageScore) {
		this.pageScore = pageScore;
	}

	/**
	 * @return the totalScore
	 */
	public Double getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "ShopDesign [id=" + id + ", moduleScore=" + moduleScore + ", pageScore=" + pageScore + ", totalScore="
				+ totalScore + "]";
	}
}
