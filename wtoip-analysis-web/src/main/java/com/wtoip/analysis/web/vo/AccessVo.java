package com.wtoip.analysis.web.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import com.wtoip.analysis.core.framwork.bean.SimpleVo;
import com.wtoip.analysis.enums.Channel;
import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.model.Goods;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public class AccessVo extends SimpleVo{
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
	 * 事件
	 */
	@NotEmpty
	private String event;
	/**
	 * 事件类型
	 */
	@NotNull
	private EventType eventType;
	/**
	 * 渠道
	 */
	@NotNull
	private Channel channel;
	/**
	 * 用户
	 */
	private String userId;
	/**
	 * 店铺
	 */
	private String mallId;
	/**
	 * 店铺名称
	 */
	private String mallName;
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
	 * 登记页面的来路URL，如  http://baidu.com/q=wtoip.com
	 */
	private String refUrl;
	/**
	 * 登记页面的URL，如  http://www.wtoip.com
	 */
	private String locUrl;
	/**
	 * 来源：刷新器：refresher
	 */
	private String source;
	/**
	 * cookie ID
	 */
	@NotEmpty
	private String cookie;
	/**
	 * 用户请求ip
	 */
	private String ip;
	/**
	 * 日期维度：2017-01-04
	 */
	private String createDate;
	/**
	 * 时间维度：13:57:27
	 */
	private String createTime;
	/**
	 * 小时维度：13
	 */
	private String createHour;
	/**
	 * 时间戳
	 */
	private Double timestamp;
	/**
	 * 停留时间(单位：毫秒)
	 */
	private Double standingTime;
	
	/*
	 * 扩展字段
	 */
	/**
	 * 商品(商品事件)
	 */
	private Goods goods;
	/**
	 * 店铺列表(用作刷新器接口店铺列表)
	 */
	private List<Mall> malls;
	/**
	 * 
	 *  @Description
	 *	@author wanghongwei
	 *  @date   2017年4月6日
	 */
	public static class Mall implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * 店铺
		 */
		private String mallId;
		/**
		 * 会员id
		 */
		private String memberId;
		/**
		 * 店铺名称
		 */
		private String mallName;
		/**
		 * 行业编码（1级）
		 */
		private String industryCode1;
		/**
		 * 行业编码（2级）
		 */
		private String industryCode2;
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
		 * @return the mallName
		 */
		public String getMallName() {
			return mallName;
		}
		/**
		 * @param mallName the mallName to set
		 */
		public void setMallName(String mallName) {
			this.mallName = mallName;
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
			return "Mall [mallId=" + mallId + ", memberId=" + memberId + ", mallName=" + mallName + ", industryCode1="
					+ industryCode1 + ", industryCode2=" + industryCode2 + "]";
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
	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
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
	 * @return the mallName
	 */
	public String getMallName() {
		return mallName;
	}
	/**
	 * @param mallName the mallName to set
	 */
	public void setMallName(String mallName) {
		this.mallName = mallName;
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
	 * @return the refUrl
	 */
	public String getRefUrl() {
		return refUrl;
	}
	/**
	 * @param refUrl the refUrl to set
	 */
	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}
	/**
	 * @return the locUrl
	 */
	public String getLocUrl() {
		return locUrl;
	}
	/**
	 * @param locUrl the locUrl to set
	 */
	public void setLocUrl(String locUrl) {
		this.locUrl = locUrl;
	}
	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}
	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}
	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	/**
	 * @return the eventType
	 */
	public EventType getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
	 * @return the createHour
	 */
	public String getCreateHour() {
		return createHour;
	}
	/**
	 * @param createHour the createHour to set
	 */
	public void setCreateHour(String createHour) {
		this.createHour = createHour;
	}
	/**
	 * @return the timestamp
	 */
	public Double getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Double timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the standingTime
	 */
	public Double getStandingTime() {
		return standingTime;
	}
	/**
	 * @param standingTime the standingTime to set
	 */
	public void setStandingTime(Double standingTime) {
		this.standingTime = standingTime;
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
	 * @return the malls
	 */
	public List<Mall> getMalls() {
		return malls;
	}
	/**
	 * @param malls the malls to set
	 */
	public void setMalls(List<Mall> malls) {
		this.malls = malls;
	}
	
	
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
		return "AccessVo [app=" + app + ", event=" + event + ", eventType=" + eventType + ", channel=" + channel
				+ ", userId=" + userId + ", mallId=" + mallId + ", mallName=" + mallName + ", memberId=" + memberId
				+ ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + ", refUrl=" + refUrl
				+ ", locUrl=" + locUrl + ", source=" + source + ", cookie=" + cookie + ", ip=" + ip + ", createDate="
				+ createDate + ", createTime=" + createTime + ", createHour=" + createHour + ", timestamp=" + timestamp
				+ ", standingTime=" + standingTime + ", goods=" + goods + ", malls=" + malls + "]";
	}
}
