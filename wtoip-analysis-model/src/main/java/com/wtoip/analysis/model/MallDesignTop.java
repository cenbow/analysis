package com.wtoip.analysis.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description 店铺装修实力排行
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Document(collection = "mall_design_top")
public class MallDesignTop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * _id
	 */
	private _Id id;
	/**
	 * 总得分
	 */
	private Double totalScore;
	/**
	 * 排名
	 */
	private Double rank;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
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
		 * 会员id
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
	 * @return the rank
	 */
	public Double getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Double rank) {
		this.rank = rank;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		return "MallDesignTop [id=" + id + ", totalScore=" + totalScore + ", rank=" + rank + ", createTime="
				+ createTime + "]";
	}
}
