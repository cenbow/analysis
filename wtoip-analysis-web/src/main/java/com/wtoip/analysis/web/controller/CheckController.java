package com.wtoip.analysis.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wtoip.analysis.biz.service.AccessService;
import com.wtoip.analysis.core.framwork.bean.ResponseResult;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Controller
public class CheckController {
	
	@Resource
	private AccessService accessService;
	
	@ResponseBody
	@RequestMapping(value="/check", method=RequestMethod.GET)
	public Object check(){
		accessService.findById("1");
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
}
