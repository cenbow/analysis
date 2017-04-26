package com.wtoip.analysis.web.handler.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.AccessClickService;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.model.AccessClick;
import com.wtoip.analysis.web.handler.BaseAccessVoHandler;
import com.wtoip.analysis.web.vo.AccessVo;
import com.wtoip.analysis.web.vo.AccessVo.Mall;


@Component
public class RefreshClickHandler extends BaseAccessVoHandler{

	@Resource
	private AccessClickService clickAccessService;
	
	@Override
	public boolean supports(EventType eventType, String event) {
		return EventType.CLICK == eventType && EventName.REFRESHER_NAME.equals(event);
	}
	
	@Override
	public void handle(AccessVo t) throws Exception {
		List<Mall> list = t.getMalls();
		for (Mall mall : list) {
			AccessClick click = new AccessClick();
			click.setApp(t.getApp());
			click.setEvent(t.getEvent());
			click.setChannel(t.getChannel());
			click.setUserId(t.getUserId());
			click.setMallId(mall.getMallId());
			click.setMallName(mall.getMallName());
			click.setMemberId(mall.getMemberId());
			click.setRefUrl(t.getRefUrl());
			click.setLocUrl(t.getLocUrl());
			click.setCookie(t.getCookie());
			click.setIp(t.getIp());
			click.setCreateDate(t.getCreateDate());
			click.setCreateTime(t.getCreateTime());
			click.setCreateHour(t.getCreateHour());
			click.setTimestamp(t.getTimestamp());
			
			clickAccessService.insert(click);
		}
		
	}

}
