package com.wtoip.analysis.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import com.wtoip.analysis.enums.Channel;

/** 
 *  @Description:源数据
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Document(collection = "access")
public class Access implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private String id;
	/**
	 * app
	 */
	private String app;
	/**
	 * 事件
	 */
	private String event;
	/**
	 * 渠道
	 */
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
	 * 商城首页
	 */
	private String mallUrl;
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
	 * cookie ID
	 */
	private String cookie;
	/**
	 * 来源：刷新器：refresher
	 */
	private String source;
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
	/**
	 * 商品
	 */
	private Goods goods;
	
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
	
	public String getMallUrl() {
		return mallUrl;
	}
	public void setMallUrl(String mallUrl) {
		this.mallUrl = mallUrl;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
	
	@Override
	public String toString() {
		return "Access [id=" + id + ", app=" + app + ", event=" + event + ", channel=" + channel + ", userId=" + userId
				+ ", mallId=" + mallId + ", mallName=" + mallName + ", mallUrl=" + mallUrl + ", memberId=" + memberId
				+ ", industryCode1=" + industryCode1 + ", industryCode2=" + industryCode2 + ", refUrl=" + refUrl
				+ ", locUrl=" + locUrl + ", cookie=" + cookie + ", source=" + source + ", ip=" + ip + ", createDate="
				+ createDate + ", createTime=" + createTime + ", createHour=" + createHour + ", timestamp=" + timestamp
				+ ", standingTime=" + standingTime + ", goods=" + goods + "]";
	}
}
