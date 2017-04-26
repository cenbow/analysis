package com.wtoip.analysis.web.handler;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.web.handler.impl.RefreshClickHandler;
import com.wtoip.analysis.web.handler.impl.SaveAccessClickHandler;
import com.wtoip.analysis.web.handler.impl.SaveAccessHandler;
import com.wtoip.analysis.web.vo.AccessVo;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Component
public class AccessVoHandlerContext extends HandlerContext<AccessVo>{

	@PostConstruct
	public void init(){
		//注册事件处理者
		registeHandler(SaveAccessHandler.class);
		registeHandler(SaveAccessClickHandler.class);
		registeHandler(RefreshClickHandler.class);
	}
	
}
