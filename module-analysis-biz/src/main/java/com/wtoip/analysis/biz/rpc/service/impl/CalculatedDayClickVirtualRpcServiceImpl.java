package com.wtoip.analysis.biz.rpc.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.CalculatedDayClickVirtualDao;
import com.wtoip.analysis.biz.service.CalculatedDayClickVirtualService;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.core.util.RandomUtil;
import com.wtoip.analysis.model.EventDayClickVirtual;
import com.wtoip.analysis.rpc.service.CalculatedDayClickVirtualRpcService;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
@Service("calculatedDayClickVirtualRpcService")
public class CalculatedDayClickVirtualRpcServiceImpl  implements CalculatedDayClickVirtualRpcService{

	@Resource
	private CalculatedDayClickVirtualService calculatedDayClickVirtualService;
	

	@Override
	public List<EventDayClickVirtual> findMallEventDateRange(String startDate, String endDate, String app,
			String memberId, String mallId, String event) throws Exception {
	
		
		return calculatedDayClickVirtualService.findMallEventDateRange(startDate, endDate, app, memberId, mallId, event);
	}
	

	@Override
	public EventDayClickVirtual findMallEventDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId, String event){
		return calculatedDayClickVirtualService.findMallEventDateRangeSum(startDate, endDate, app, memberId, mallId, event);
	}

}
