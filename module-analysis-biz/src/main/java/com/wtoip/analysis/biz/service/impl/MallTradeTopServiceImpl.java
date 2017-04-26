package com.wtoip.analysis.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.CalculatedDayVirtualDao;
import com.wtoip.analysis.biz.dao.MallTradeTopDao;
import com.wtoip.analysis.biz.dao.OrderDayDao;
import com.wtoip.analysis.biz.service.MallTradeTopService;
import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.model.CalculatedDayVirtual;
import com.wtoip.analysis.model.MallTradeTop;
import com.wtoip.analysis.model.OrderDay;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月20日
 */
@Service("mallTradeTopService")
public class MallTradeTopServiceImpl extends BaseService<MallTradeTop> implements MallTradeTopService{

	private Logger log = LoggerFactory.getLogger(MallTradeTopServiceImpl.class);
	
	@Resource
	private MallTradeTopDao mallTradeTopDao;
	
	@Resource
	private CalculatedDayVirtualDao calculatedDayVirtualDao;
	
	@Resource
	private OrderDayDao orderDayDao;

	@Override
	protected Dao<MallTradeTop> getDao() {
		return mallTradeTopDao;
	}

	@Override
	public void analysisMallTradeTopByDateRange(String startDate, String endDate) {
		log.info("analysisMallTradeTopByDateRange:startDate={},endDate={}",startDate,endDate);
		//行业分类map
		Map<String,String> industryCodeMap = new HashMap<>(); 
		
		//先计算得分
		int pageSize = 5000;
		int currPage = 1;
		int currPageSize = pageSize;
		Page page = new Page();
		page.setRows(pageSize);
		
		while(currPageSize == pageSize){
			page.setPage(currPage);
			
			PageResult<CalculatedDayVirtual> pageResult = calculatedDayVirtualDao.findMallAggregationDateRange(page, startDate, endDate);
			List<CalculatedDayVirtual> calculatedDayList = pageResult.getData();
			
			for(CalculatedDayVirtual calculatedDay : calculatedDayList){
				//店铺交易实力排行=交易额+（订单量*1000）+（转化率*10000）+店铺曝光量
				Double totalScore = calculatedDay.getValue().getPv();
				OrderDay orderDay = orderDayDao.findOrderDateRangeSum(startDate, endDate, calculatedDay.getId().getApp(),  calculatedDay.getId().getMemberId());
				if(orderDay != null){
					totalScore += orderDay.getValue().getTradeFee() + orderDay.getValue().getTotalQty()*1000 + (orderDay.getValue().getTotalQty()/calculatedDay.getValue().getUv())*10000;
				}
				
				MallTradeTop mallTradeTop = new MallTradeTop();
				MallTradeTop._Id id = new MallTradeTop._Id();
				mallTradeTop.setId(id);
				mallTradeTop.getId().setApp(calculatedDay.getId().getApp());
				mallTradeTop.getId().setMemberId(calculatedDay.getId().getMemberId());
				mallTradeTop.getId().setIndustryCode1(calculatedDay.getId().getIndustryCode1());
				mallTradeTop.getId().setIndustryCode2(calculatedDay.getId().getIndustryCode2());
				mallTradeTop.getId().setStartDate(startDate);
				mallTradeTop.getId().setEndDate(endDate);
				
				mallTradeTop.setTotalScore(totalScore);
				mallTradeTop.setCreateTime(new Date());
				
				mallTradeTopDao.update(mallTradeTop);
				
				String industry = calculatedDay.getId().getIndustryCode1() + "#" +calculatedDay.getId().getIndustryCode2();
				industryCodeMap.put(industry, null);
 			}
			
			currPageSize = calculatedDayList.size();
			currPage++;
		}
		
		
		//更新行业排名
		Double rank = 1D;
		for(String key : industryCodeMap.keySet()){
			String[] industry = key.split("#");
			String industry1 = industry[0];
			String industry2 = industry[1];
			
			List<MallTradeTop> dataList = mallTradeTopDao.findSortMallTradeTop(startDate, endDate, industry1, industry2);
			for(MallTradeTop mallTradeTop : dataList){
				mallTradeTop.setRank(rank);
				mallTradeTopDao.update(mallTradeTop);
				rank++;
			}
			
		}
		
	}

	@Override
	public List<MallTradeTop> findLastTwoData(String app, String memberId, String mallId) {
		return mallTradeTopDao.findLastTwoData(app, memberId);
	}
	
}
