package com.wtoip.analysis.web.controller;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wtoip.analysis.biz.util.Constants.DefaultValue;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.core.framwork.bean.ResponseResult;
import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.core.util.IpUtils;
import com.wtoip.analysis.core.util.JSR303Util;
import com.wtoip.analysis.web.handler.AccessVoHandlerContext;
import com.wtoip.analysis.web.vo.AccessVo;

/**
 * @Description:
 * @author wanghongwei
 * @date: 2017年3月20日
 */
@Controller
@RequestMapping("/access")
public class AccessController {

	private Logger log = LoggerFactory.getLogger(AccessController.class);
	
	@Resource
	private AccessVoHandlerContext accessHandlerContext;
	
	@ResponseBody
	@RequestMapping(value="/put", method=RequestMethod.POST)
	public Object put(@RequestBody AccessVo accessVo, HttpServletRequest request) throws Exception {
		// 简单数据校验
		JSR303Util.validate(accessVo);
		
		checkValue(accessVo);
		setValue(accessVo,request);
		
		accessHandlerContext.handle(accessVo);

		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	/**
	 * 数据检查
	 * @param access
	 */
	private void checkValue(AccessVo accessVo){
		if(EventName.GOODS_NAME.equals(accessVo.getEvent()) && accessVo.getGoods() == null){
			throw new BaseException("goods is null");
		}
	}

	/**
	 * 
	 * @param access
	 * @param request
	 */
	private void setValue(AccessVo accessVo, HttpServletRequest request) {
		if (accessVo.getMemberId() == null || "".equals(accessVo.getMemberId())) {
			accessVo.setMemberId(DefaultValue.DEFAULT_MEMBERID);
		}
		if(accessVo.getMallId() == null || "".equals(accessVo.getMallId())){
			accessVo.setMallId(DefaultValue.DEFAULT_MALLID);
		}
		if (accessVo.getMemberId() == null || "".equals(accessVo.getMemberId())) {
			accessVo.setMemberId(DefaultValue.DEFAULT_MEMBERID);
		}
		if (accessVo.getIndustryCode1() == null || "".equals(accessVo.getIndustryCode1())) {
			accessVo.setIndustryCode1(DefaultValue.DEFAULT_INDUSTRY_CODE);
		}
		if (accessVo.getIndustryCode2() == null || "".equals(accessVo.getIndustryCode2())) {
			accessVo.setIndustryCode2(DefaultValue.DEFAULT_INDUSTRY_CODE);
		}
		
		if(accessVo.getStandingTime() == null){
			accessVo.setStandingTime(0D);
		}
		
		Date now = new Date();
		accessVo.setTimestamp(Double.valueOf(now.getTime()));
		accessVo.setCreateDate(DateUtil.getDay(now));
		accessVo.setCreateTime(DateUtil.getTime(now));
		accessVo.setCreateHour(DateUtil.getHour(now));
		
		// 获取请求id
		String ip = IpUtils.getIpAddr(request);
		accessVo.setIp(ip);
	}
}
