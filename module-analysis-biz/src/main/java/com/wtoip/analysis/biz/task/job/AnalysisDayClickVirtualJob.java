package com.wtoip.analysis.biz.task.job;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.wtoip.analysis.biz.service.CalculatedDayClickService;
import com.wtoip.analysis.biz.service.CalculatedDayClickVirtualService;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.job.Job;
import com.wtoip.analysis.core.util.RandomUtil;
import com.wtoip.analysis.model.EventDayClick;
import com.wtoip.analysis.model.EventDayClickVirtual;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月6日
 */
@Component
public class AnalysisDayClickVirtualJob implements Job<String>{

	@Resource
	private CalculatedDayClickService calculatedDayClickService;
	
	@Resource
	private CalculatedDayClickVirtualService calculatedDayClickVirtualService;
	
	@Override
	public void execute(String t) throws Exception {
		//只有刷新器需要虚拟数据
		String[] propName ={"_id.createDate","_id.event"};
		String[] propValue ={t,EventName.REFRESHER_NAME};
		
		int pageSize = 5000;
		int currPage = 1;
		
		int currPageSize = pageSize;
		
		Page page = new Page();
		page.setRows(pageSize);
		
		while(currPageSize == pageSize){
			page.setPage(currPage);
			
			PageResult<EventDayClick> pageResult = calculatedDayClickService.findAllPage(page, propName, propValue);
			
			List<EventDayClick> list = pageResult.getData();
			
			for(EventDayClick calculatedDay : list){
				calculateVirtualData(calculatedDay);
			}
			
			currPageSize = list.size();
			currPage++;
		}
		
	}
	
	
	public void calculateVirtualData(EventDayClick eventDayClick){
		EventDayClickVirtual eventDayClickVirtual = new EventDayClickVirtual();
		eventDayClickVirtual.setId(eventDayClick.getId());
		
		EventDayClick._Value value = eventDayClick.getValue();
		eventDayClickVirtual.setValue(value);
		
		Double pv = value.getPv();
		if(pv > 0){
			//（800~999随机数）】+（真实展现pv*5）&尾部随机数(存在真实数据)
			pv = Double.valueOf(RandomUtil.getRandom(800, 999)) + pv*5 + RandomUtil.getRandom(10);
		}
		value.setPv(pv);
		calculatedDayClickVirtualService.update(eventDayClickVirtual);
	}
}
