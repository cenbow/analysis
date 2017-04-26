package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.CalculatedDayVirtualService;
import com.wtoip.analysis.model.CalculatedDayVirtual;
import com.wtoip.analysis.rpc.service.CalculatedDayVirtualRpcService;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月10日
 */
@Service("calculatedDayVirtualRpcService")
public class CalculatedDayVirtualRpcServiceImpl implements CalculatedDayVirtualRpcService{

	@Resource
	private CalculatedDayVirtualService calculatedDayVirtualService;
	

	@Override
	public List<CalculatedDayVirtual> findMallDateRange(String startDate, String endDate, String app, String memberId,
			String mallId,String industryCode1,String industryCode2) throws Exception {
		
		
		return calculatedDayVirtualService.findMallDateRange(startDate, endDate, app, memberId, mallId, industryCode1, industryCode2);
	}

	@Override
	public CalculatedDayVirtual findMallDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId) {
		return calculatedDayVirtualService.findMallDateRangeSum(startDate, endDate, app, memberId, mallId);
	}
}
