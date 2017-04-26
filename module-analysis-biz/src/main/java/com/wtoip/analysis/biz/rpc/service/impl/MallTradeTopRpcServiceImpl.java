package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.MallTradeTopService;
import com.wtoip.analysis.model.MallTradeTop;
import com.wtoip.analysis.rpc.service.MallTradeTopRpcService;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月21日
 */
@Service("mallTradeTopRpcService")
public class MallTradeTopRpcServiceImpl implements MallTradeTopRpcService{

	@Resource
	private MallTradeTopService mallTradeTopService;
	
	@Override
	public List<MallTradeTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallTradeTopService.findLastTwoData(app, memberId, mallId);
	}

}
