package com.wtoip.analysis.web.handler.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.wtoip.analysis.core.util.BeanUtil;
import com.wtoip.analysis.biz.service.AccessClickService;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.model.AccessClick;
import com.wtoip.analysis.web.handler.BaseAccessVoHandler;
import com.wtoip.analysis.web.vo.AccessVo;


@Component
public class SaveAccessClickHandler extends BaseAccessVoHandler{

	@Resource
	private AccessClickService clickAccessService;
	
	@Override
	public boolean supports(EventType eventType, String event) {
		return EventType.CLICK == eventType && !EventName.REFRESHER_NAME.equals(event);
	}
	
	@Override
	public void handle(AccessVo t) throws Exception {
		
		AccessClick accessClick = BeanUtil.copyProperties(t, AccessClick.class);
		clickAccessService.insert(accessClick);
	}

}
