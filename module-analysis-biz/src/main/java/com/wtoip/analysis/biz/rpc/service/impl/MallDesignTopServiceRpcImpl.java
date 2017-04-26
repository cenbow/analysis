package com.wtoip.analysis.biz.rpc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.service.MallDesignTopService;
import com.wtoip.analysis.model.MallDesignTop;
import com.wtoip.analysis.rpc.service.MallDesignTopRpcService;

/** 
 *  @Description
 *	@author 木四点
 *  @date   2017年4月11日
 */
@Service("mallDesignTopRpcService")
public class MallDesignTopServiceRpcImpl  implements MallDesignTopRpcService{
	
	@Resource
	private MallDesignTopService mallDesignTopService;
	@Override
	public void analysisMallDesignTopByDay(String createDate) {
		mallDesignTopService.analysisMallDesignTopByDay(createDate);
	}

	@Override
	public List<MallDesignTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallDesignTopService.findLastTwoData(app, memberId, mallId);
	}

}
