package com.wtoip.analysis.model;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "logpv")
public class LogPv implements Serializable{
	//对应着MongoDB中mongodb.wtoipapi.com", 27017, "wtoipx"库logpv表中的每一行记录
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;  //logPage._id or 约定的名称,  wtoip.log.web
	private String userName;    //SSO Login Username or Unknown
	private String typeid;      //Default or ExitLog(退出时记录，仅用于停留时间计算)  
    private String loginType;   //Default or QQLogin or WXLogin or WBLogin（分移动渠道统计）
    private HashMap<String,Object> ident;  //Ident(IP + COOKIE) 唯一值视为UV，  Ident.IP唯一值视为IP 
    private String refUrl; //登记页面的来路URL，如  http://baidu.com/q=wtoip.com
    private String locUrl; //登记页面的URL，如  http://www.wtoip.com
	private String createDate; //日期维度用
	private String createTime; //时间维度用
	private String userTime; //记录用户端时间
	private int createHour; //小时维度用
	private Integer pageSeconds; //页面停留时间秒数
	private HashMap<String, Object> custom; //自定义JSON值

	@Override
	public String toString() {
		return "LogPv [name=" + name + ", userName=" + userName + ", typeid=" + typeid + ", loginType=" + loginType
				+ ", ident=" + ident + ", refUrl=" + refUrl + ", locUrl=" + locUrl + ", createDate=" + createDate
				+ ", createTime=" + createTime + ", userTime=" + userTime + ", createHour=" + createHour
				+ ", pageSeconds=" + pageSeconds + ", custom=" + custom + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public HashMap<String, Object> getIdent() {
		return ident;
	}

	public void setIdent(HashMap<String, Object> ident) {
		this.ident = ident;
	}

	public String getRefUrl() {
		return refUrl;
	}

	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}

	public String getLocUrl() {
		return locUrl;
	}

	public void setLocUrl(String locUrl) {
		this.locUrl = locUrl;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public int getCreateHour() {
		return createHour;
	}

	public void setCreateHour(int createHour) {
		this.createHour = createHour;
	}

	public Integer getPageSeconds() {
		return pageSeconds;
	}

	public void setPageSeconds(Integer pageSeconds) {
		this.pageSeconds = pageSeconds;
	}

	public HashMap<String, Object> getCustom() {
		return custom;
	}

	public void setCustom(HashMap<String, Object> custom) {
		this.custom = custom;
	}

}