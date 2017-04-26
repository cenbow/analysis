package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.bean.MallPvTopAdapter;
import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.MallPvTop;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
@Component
public class MallPvTopConverter extends BaseConverter<MallPvTopAdapter,MallPvTop>{


	@Override
	public MallPvTop convert(MallPvTopAdapter s) {
		MallPvTop mallPvTop = new MallPvTop();
		
		MallPvTop._Id id = new MallPvTop._Id();
		id.setApp(s.getApp());
		id.setMemberId(s.getMemberId());
		id.setMallId(s.getMallId());
		mallPvTop.setId(id);
		
		mallPvTop.setPv(s.getPv());
		
		return mallPvTop;
	}

}
