package com.wtoip.analysis.biz.task.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.MallDesignTopService;
import com.wtoip.analysis.core.framwork.job.Job;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月7日
 */
@Component
public class MallDesignTopJob implements Job<String>{

	@Resource
	private MallDesignTopService mallDesignTopService;
	
	@Override
	public void execute(String t) throws Exception {
		
		mallDesignTopService.analysisMallDesignTopByDay(t);
	}

}
