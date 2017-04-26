package com.wtoip.analysis.biz.task.job;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.biz.service.LogPvService;
import com.wtoip.analysis.biz.util.Constants.DefaultValue;
import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.enums.Channel;
import com.wtoip.analysis.model.Access;
import com.wtoip.analysis.model.Goods;
import com.wtoip.analysis.model.LogPv;
/**
 * @author 木四点
 * @date 2017年3月21日
 */
@Component
public class MoveDataJob{
	
	Logger logger = LoggerFactory.getLogger(MoveDataJob.class);

	@Resource
	private AccessService accessService;
	
	@Resource
	private LogPvService logPvService;
	
	public void execute(){
		
		String[] str ={"typeid"};
		String[] str2 ={"ExitLog"};
		// TODO Auto-generated method stub
		int i =1;
		Page page = new Page();
		page.setRows(100);
		page.setPage(i);
		page.setCount(false);
		PageResult<LogPv> result = logPvService.findAllPage(page,str,str2);
		movedata(result.getData());
		while (result.getData().size()==100) {
			page.setPage(++i);
			result = logPvService.findAllPage(page,str,str2);
			movedata(result.getData());
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	private void movedata(List<LogPv> logs){
		for (LogPv logPv : logs) {
			Access ac = new Access();
			Goods good = new Goods();
			//商城
			ac.setApp("MALL");
			ac.setId(logPv.getId());
			if(logPv.getCustom().get("mallName")!=null){
				ac.setMallName(logPv.getCustom().get("mallName").toString());
			}if(logPv.getCustom().get("mallid")!=null){
				ac.setMallId(logPv.getCustom().get("mallid").toString());
			}if(logPv.getCustom().get("mallUrl")!=null){
				ac.setMallUrl(logPv.getCustom().get("mallUrl").toString());
			}if(logPv.getCustom().get("memberid")!=null){
				ac.setMemberId(logPv.getCustom().get("memberid").toString());
			}if(logPv.getCustom().get("type")!=null){
				ac.setEvent(logPv.getCustom().get("type").toString());
			}
			//用户
			if(logPv.getUserName()!=null){
				ac.setUserId(logPv.getUserName());
			}
			if(logPv.getIdent().get("cookie")!=null){
				ac.setCookie(logPv.getIdent().get("cookie").toString());
			}if(logPv.getIdent().get("ip")!=null){
				ac.setIp(logPv.getIdent().get("ip").toString());
			}
			//商品
			if(logPv.getCustom().get("goodsImg")!=null){
				good.setGoodsImg(logPv.getCustom().get("goodsImg").toString());
			}if(logPv.getCustom().get("goodsName")!=null){
				good.setGoodsName(logPv.getCustom().get("goodsName").toString());
			}if(logPv.getCustom().get("goodsUrl")!=null){
				good.setGoodsUrl(logPv.getCustom().get("goodsUrl").toString());
			}if(logPv.getCustom().get("goodsId")!=null){
				good.setGoodsId(logPv.getCustom().get("goodsId").toString());
			}
			ac.setGoods(good);
			//其他
			if(logPv.getRefUrl()!=null){
				ac.setRefUrl(logPv.getRefUrl());
			}if(logPv.getLocUrl()!=null){
				ac.setLocUrl(logPv.getLocUrl());
			}if(logPv.getCreateDate()!=null){
				ac.setCreateDate(logPv.getCreateDate());
			}if(logPv.getCreateTime()!=null){
				ac.setCreateTime(logPv.getCreateTime());
			}if(logPv.getCreateHour()!=0){
				ac.setCreateHour(String.valueOf(logPv.getCreateHour()));
			}if(logPv.getPageSeconds()!=null){
				ac.setStandingTime((double)logPv.getPageSeconds());
			}
			
			setDefaultValue(ac);
			
			accessService.update(ac);
		}
		logger.info("@@@@@@@@@@@@@@@@@@");
	}

	
	private void setDefaultValue(Access access) {
		if (access.getMemberId() == null || "".equals(access.getMemberId())) {
			access.setMemberId(DefaultValue.DEFAULT_MEMBERID);
		}
		if(access.getMallId() == null || "".equals(access.getMallId())){
			access.setMallId(DefaultValue.DEFAULT_MALLID);
		}
		if (access.getIndustryCode1() == null || "".equals(access.getIndustryCode1())) {
			access.setIndustryCode1(DefaultValue.DEFAULT_INDUSTRY_CODE);
		}
		if (access.getIndustryCode2() == null || "".equals(access.getIndustryCode2())) {
			access.setIndustryCode2(DefaultValue.DEFAULT_INDUSTRY_CODE);
		}
		
		if(access.getStandingTime() == null){
			access.setStandingTime(0D);
		}
		access.setChannel(Channel.WAP);
		if("GOOD".equals(access.getEvent())){
			access.setEvent("GOODS_PAGE");
		}
		if("MAIN".equals(access.getEvent())){
			access.setEvent("MAIN_PAGE");
		}
		if(access.getTimestamp() == null){
			access.setTimestamp(1D);
		}
	}
}
