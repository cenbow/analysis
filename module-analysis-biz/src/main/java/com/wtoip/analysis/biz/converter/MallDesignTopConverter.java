package com.wtoip.analysis.biz.converter;

import org.springframework.stereotype.Component;

import com.wtoip.analysis.core.framwork.converter.BaseConverter;
import com.wtoip.analysis.model.MallDesignTop;
import com.wtoip.analysis.model.ShopDesign;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class MallDesignTopConverter extends BaseConverter<ShopDesign,MallDesignTop>{

	@Override
	public MallDesignTop convert(ShopDesign s) {
		MallDesignTop mallDesignTop = new MallDesignTop();
		MallDesignTop._Id id = new MallDesignTop._Id();
		
		id.setCreateDate(s.getId().getCreateDate());
		id.setApp(s.getId().getApp());
		id.setMemberId(s.getId().getMemberId());
		id.setMallId(s.getId().getMallId());
		id.setIndustryCode1(s.getId().getIndustryCode1());
		id.setIndustryCode2(s.getId().getIndustryCode2());
		
		mallDesignTop.setId(id);
		mallDesignTop.setTotalScore(s.getTotalScore());
		
		return mallDesignTop;
	}

}
