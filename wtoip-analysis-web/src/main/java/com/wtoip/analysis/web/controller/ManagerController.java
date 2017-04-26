package com.wtoip.analysis.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wtoip.analysis.biz.task.job.AnalysisDayClickJob;
import com.wtoip.analysis.biz.task.job.AnalysisDayClickVirtualJob;
import com.wtoip.analysis.biz.task.job.AnalysisDayJob;
import com.wtoip.analysis.biz.task.job.AnalysisDayOrderJob;
import com.wtoip.analysis.biz.task.job.AnalysisDayVirtualJob;
import com.wtoip.analysis.biz.task.job.AnalysisOrderTradeDayJob;
import com.wtoip.analysis.biz.task.job.CalculatedLast30DaysJob;
import com.wtoip.analysis.biz.task.job.MallDesignTopJob;
import com.wtoip.analysis.biz.task.job.MallPvTopJob;
import com.wtoip.analysis.biz.task.job.MallTradeTopJob;
import com.wtoip.analysis.biz.task.job.MoveDataJob;
import com.wtoip.analysis.core.framwork.bean.ResponseResult;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月12日
 */
@Controller
@RequestMapping("/manager/job")
public class ManagerController {

	@Resource
	private AnalysisDayClickJob analysisDayClickJob;
	
	@Resource
	private AnalysisDayClickVirtualJob analysisDayClickVirtualJob;
	
	@Resource
	private AnalysisDayJob analysisDayJob;
	
	@Resource
	private AnalysisDayVirtualJob analysisDayVirtualJob;
	
	@Resource
	private MallDesignTopJob mallDesignTopJob;
	
	@Resource
	private MallPvTopJob mallPvTopJob;
	
	@Resource
	private MoveDataJob moveDataJob;
	
	@Resource
	private CalculatedLast30DaysJob calculatedLast30DaysJob;
	
	@Resource
	private MallTradeTopJob mallTradeTopJob;
	
	@Resource
	private AnalysisOrderTradeDayJob analysisOrderTradeDayJob;
	
	@Resource
	private AnalysisDayOrderJob analysisDayOrderJob;
	
	
	@ResponseBody
	@RequestMapping(value="/analysisDayJob", method=RequestMethod.GET)
	public Object analysisDayJob(String date) throws Exception{
		analysisDayJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisDayVirtualJob", method=RequestMethod.GET)
	public Object analysisDayVirtualJob(String date) throws Exception{
		analysisDayVirtualJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisDayClickJob", method=RequestMethod.GET)
	public Object analysisDayClickJob(String date) throws Exception{
		analysisDayClickJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisDayClickVirtualJob", method=RequestMethod.GET)
	public Object analysisDayClickVirtualJob(String date) throws Exception{
		analysisDayClickVirtualJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/mallDesignTopJob", method=RequestMethod.GET)
	public Object mallDesignTopJob(String date) throws Exception{
		mallDesignTopJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/mallPvTopJob", method=RequestMethod.GET)
	public Object mallPvTopJob(String startDate,String endDate) throws Exception{
		mallPvTopJob.execute(new String[]{startDate,endDate});
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/moveDataJob", method=RequestMethod.GET)
	public Object moveDataJob() throws Exception{
		moveDataJob.execute();
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/calculatedLast30DaysJob", method=RequestMethod.GET)
	public Object calculatedLast30DaysJob() throws Exception{
		calculatedLast30DaysJob.execute();
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/mallTradeTopJob", method=RequestMethod.GET)
	public Object mallTradeTopJob(String startDate,String endDate) throws Exception{
		mallTradeTopJob.execute(new String[]{startDate,endDate});
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisOrderTradeDayJob", method=RequestMethod.GET)
	public Object analysisOrderTradeDayJob(String date) throws Exception{
		analysisOrderTradeDayJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/analysisDayOrderJob", method=RequestMethod.GET)
	public Object analysisDayOrderJob(String date) throws Exception{
		analysisDayOrderJob.execute(date);
		return ResponseResult.newInstance().success().message("请求成功");
	}
}
