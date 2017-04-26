package com.wtoip.analysis.biz.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.OrderDayDao;
import com.wtoip.analysis.biz.service.OrderDayService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.model.OrderDay;

/**
 * @Description
 * @author wanghongwei
 * @date 2017年4月20日
 */
@Service("orderDayService")
public class OrderDayServiceImpl extends BaseService<OrderDay> implements OrderDayService {

	@Resource
	private OrderDayDao orderDayDao;

	@Override
	protected Dao<OrderDay> getDao() {
		return orderDayDao;
	}

	@Override
	public List<OrderDay> findOrderDateRange(String startDate, String endDate, String app, String memberId)
			throws Exception {
		List<OrderDay> dataList = orderDayDao.findOrderDateRange(startDate, endDate, app, memberId);

		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = DateFormat.parse(startDate);
		Date eDate = DateFormat.parse(endDate);
		int days = DateUtil.daysBetween(sDate, eDate) + 1;

		if (days <= dataList.size()) {
			return dataList;
		}

		List<OrderDay> generateDataList = new ArrayList<>(days);
		while (sDate.compareTo(eDate) <= 0) {
			String createDate = DateUtil.getDay(sDate);
			OrderDay orderDay = null;
			for (OrderDay od : dataList) {
				if (createDate.equals(od.getId().getCreateDate())) {
					orderDay = od;
					break;
				}
			}
			if (orderDay == null) {
				orderDay = generateOrderDay(createDate, app, memberId);
			}

			generateDataList.add(orderDay);

			sDate = DateUtil.addDays(sDate, 1);
		}
		return generateDataList;

	}

	@Override
	public OrderDay findOrderDateRangeSum(String startDate, String endDate, String app, String memberId) {
		OrderDay orderDay = orderDayDao.findOrderDateRangeSum(startDate, endDate, app, memberId);
		if(orderDay == null){
			orderDay = generateOrderDay(null, app, memberId);
		}
		return orderDay;
	}

	private OrderDay generateOrderDay(String date, String app, String memberId) {
		OrderDay orderDay = new OrderDay();

		OrderDay._Id id = new OrderDay._Id();
		id.setCreateDate(date);
		id.setApp(app);
		id.setMemberId(memberId);
		orderDay.setId(id);

		OrderDay._Value value = new OrderDay._Value();
		value.setTradeFee(0D);
		value.setCommissionFee(0D);
		value.setTotalFee(0D);
		value.setTotalQty(0D);
		value.setValidQty(0D);
		value.setInvalidQty(0D);
		orderDay.setValue(value);

		return orderDay;
	}
}
