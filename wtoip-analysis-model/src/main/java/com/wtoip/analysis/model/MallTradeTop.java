package com.wtoip.analysis.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description 店铺交易排行
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Document(collection = "mall_trade_top")
public class MallTradeTop implements Serializable{
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
		 * app
		 */
		private String app;
		/**
		 * 会员id
		 */
		private String memberId;
		/**
		 * 行业编码（1级）
		 */
		private String industryCode1;
		/**
		 * 行业编码（2级）
		 */
		private String industryCode2;
		/**
		 * 开始时间：2017-01-04
		 */
		private String startDate;
		/**
		 * 结束：2017-01-04
		 */
		private String endDate;
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
		 * @return the startDate
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * @param startDate the startDate to set
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		/**
		 * @return the endDate
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * @param endDate the endDate to set
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		
		@Override
		public String toString() {
			return "_Id [app=" + app + ", memberId=" + memberId + ", industryCode1=" + industryCode1
					+ ", industryCode2=" + industryCode2 + ", startDate=" + startDate + ", endDate=" + endDate + "]";
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

	@Override
	public String toString() {
		return "MallTradeTop [id=" + id + ", totalScore=" + totalScore + ", rank=" + rank + ", createTime=" + createTime
				+ "]";
	}
	
}
