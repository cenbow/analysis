package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.MallPvTopService;
import com.wtoip.analysis.model.MallPvTop;
import com.wtoip.analysis.rpc.service.MallPvTopRpcService;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月11日
 */
@Service("mallPvTopRpcService")
public class MallPvTopServiceImpl  implements MallPvTopRpcService{
	
	@Resource
	private MallPvTopService mallPvTopService;
	
	@Override
	public void analysisMallPvTopByDateRange(String startDate, String endDate) {
		mallPvTopService.analysisMallPvTopByDateRange(startDate, endDate);
	}

	@Override
	public List<MallPvTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallPvTopService.findLastTwoData(app, memberId, mallId);
	}

}
