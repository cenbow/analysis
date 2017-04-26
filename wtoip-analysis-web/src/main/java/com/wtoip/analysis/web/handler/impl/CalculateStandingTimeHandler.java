package com.wtoip.analysis.web.handler.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.model.Access;
import com.wtoip.analysis.web.handler.BaseAccessVoHandler;
import com.wtoip.analysis.web.vo.AccessVo;

/** 
 *  @Description 根据用户访问记录计算页面停留时间
 *	@author wanghongwei
 *  @date   2017年3月28日
 */
@Component
public class CalculateStandingTimeHandler extends BaseAccessVoHandler{

	@Resource
	private AccessService accessService;
	
	private static final Double HALF_HOUR_TIME = 1000*60*30D;
	
	private static final Double TEN_MINUTE_TIME = 1000*60*10D;
	
	@Override
	public boolean supports(EventType eventType, String event) {
		return EventType.PAGE == eventType;
	}
	
	@Override
	public void handle(AccessVo t) throws Exception {
		Access last = accessService.findLastByCookieAndIp(t.getCookie(), t.getIp());
		if(last == null || last.getTimestamp() == null){
			return;
		}
		
		Double standingTime = t.getTimestamp() - last.getTimestamp();
		
		//超过半小时无效
		if(standingTime > HALF_HOUR_TIME){
			return;
		}
		//大于10分钟，按10分钟计算
		if(standingTime > TEN_MINUTE_TIME){
			standingTime = TEN_MINUTE_TIME;
		}
		
		//更新页面停留时间
		last.setStandingTime(standingTime);
		accessService.update(last);
	}

}
