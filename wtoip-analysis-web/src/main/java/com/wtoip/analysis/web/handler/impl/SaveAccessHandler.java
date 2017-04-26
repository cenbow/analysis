package com.wtoip.analysis.web.handler.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.core.util.BeanUtil;
import com.wtoip.analysis.enums.EventType;
import com.wtoip.analysis.model.Access;
import com.wtoip.analysis.web.handler.BaseAccessVoHandler;
import com.wtoip.analysis.web.vo.AccessVo;

/** 
 *  @Description:保存所有记录
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Component
public class SaveAccessHandler extends BaseAccessVoHandler{

	@Resource
	private AccessService accessService;
	
	@Override
	public boolean supports(EventType eventType, String event) {
		return EventType.PAGE == eventType;
	}
	
	@Override
	public void handle(AccessVo t) throws Exception {
		
		Access access = BeanUtil.copyProperties(t, Access.class);
		accessService.insert(access);
	}

}
