package com.wtoip.analysis.biz.task.job;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.wtoip.analysis.biz.service.CalculatedDayClickVirtualService;
import com.wtoip.analysis.biz.service.CalculatedDayService;
import com.wtoip.analysis.biz.service.CalculatedDayVirtualService;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.job.Job;
import com.wtoip.analysis.core.util.RandomUtil;
import com.wtoip.analysis.model.CalculatedDay;
import com.wtoip.analysis.model.CalculatedDayVirtual;
import com.wtoip.analysis.model.EventDayClickVirtual;

/** 
 *  @Description 店铺虚拟数据
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Component
public class AnalysisDayVirtualJob implements Job<String>{

	@Resource
	private CalculatedDayService calculatedDayService;
	
	@Resource
	private CalculatedDayVirtualService calculatedDayVirtualService;
	
	@Resource
	private CalculatedDayClickVirtualService calculatedDayClickVirtualService;
	
	@Override
	public void execute(String t) throws Exception { 
		String[] propName ={"_id.createDate"};
		String[] propValue ={t};
		
		int pageSize = 5000;
		int currPage = 1;
		
		int currPageSize = pageSize;
		
		Page page = new Page();
		page.setRows(pageSize);
		
		while(currPageSize == pageSize){
			page.setPage(currPage);
			
			PageResult<CalculatedDay> pageResult = calculatedDayService.findAllPage(page, propName, propValue);
			
			List<CalculatedDay> list = pageResult.getData();
			
			for(CalculatedDay calculatedDay : list){
				calculateVirtualData(calculatedDay);
			}
			
			currPageSize = list.size();
			currPage++;
		}
		
		
	}
	
	public void calculateVirtualData(CalculatedDay calculatedDay){
		CalculatedDayVirtual calculatedDayVirtual = new CalculatedDayVirtual();
		CalculatedDay._Id id = calculatedDay.getId();
		calculatedDayVirtual.setId(id);
		
		CalculatedDay._Value value = calculatedDay.getValue();
		calculatedDayVirtual.setValue(value);
		
		Double pv = value.getPv();
		Double uv = value.getUv();
		Double rpv = value.getRpv();
		
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualService.findMallEventDay(id.getCreateDate(), id.getApp(), id.getMemberId(), id.getMallId(), EventName.REFRESHER_NAME);
		
		//(5000~7000随机数)+（真实pv*5）&尾部随机数
		pv = Double.valueOf(RandomUtil.getRandom(5000, 7000)) + pv*5 + RandomUtil.getRandom(10);
		//加上刷新器的曝光量
		if(eventDayClickVirtual != null){
			pv += eventDayClickVirtual.getValue().getPv();
		}
		//100~200随机数 +（真实uv*5）&尾部随机数
		uv = Double.valueOf(RandomUtil.getRandom(100, 200)) + uv*5 + RandomUtil.getRandom(10);
		//（40~80随机数）】+（真实展现pv*5）&尾部随机数(必须存在真实数据)
		if(rpv > 0){
			rpv = Double.valueOf(RandomUtil.getRandom(40, 80)) + rpv*5 + RandomUtil.getRandom(10);
		}

		value.setPv(pv);
		value.setUv(uv);
		value.setRpv(rpv);
		
		calculatedDayVirtualService.update(calculatedDayVirtual);
	}

}
