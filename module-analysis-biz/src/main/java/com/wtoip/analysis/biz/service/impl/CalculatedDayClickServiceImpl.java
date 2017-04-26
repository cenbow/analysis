package com.wtoip.analysis.biz.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.CalculatedDayClickDao;
import com.wtoip.analysis.biz.service.CalculatedDayClickService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.model.EventDayClick;

/**
 * @Description:
 * @author wanghongwei
 * @date: 2017年3月23日
 */
@Service("calculatedDayClickService")
public class CalculatedDayClickServiceImpl extends BaseService<EventDayClick> implements CalculatedDayClickService {

	@Resource
	private CalculatedDayClickDao calculatedDayClickDao;

	@Override
	protected Dao<EventDayClick> getDao() {
		return calculatedDayClickDao;
	}

	/**
	 * 按时间范围查询事件PV,UV,IP
	 * 
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 * @throws Exception
	 */
	public List<EventDayClick> findMallEventDateRange(String startDate, String endDate, String app, String memberId,
			String mallId, String event) throws Exception {
		List<EventDayClick> dataList = calculatedDayClickDao.findMallEventDateRange(startDate, endDate, app, memberId,
				mallId, event);
		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = DateFormat.parse(startDate);
		Date eDate = DateFormat.parse(endDate);
		int days = DateUtil.daysBetween(sDate, eDate) + 1;

		if (days <= dataList.size()) {
			return dataList;
		}

		List<EventDayClick> generateDataList = new ArrayList<>(days);
		while (sDate.compareTo(eDate) <= 0) {
			String createDate = DateUtil.getDay(sDate);
			EventDayClick eventDayClick = null;
			for (EventDayClick edv : dataList) {
				if (createDate.equals(edv.getId().getCreateDate())) {
					eventDayClick = edv;
					break;
				}
			}
			if (eventDayClick == null) {
				eventDayClick = generateDefaultData(createDate, app, memberId, mallId, event);
			}

			generateDataList.add(eventDayClick);

			sDate = DateUtil.addDays(sDate, 1);
		}
		return generateDataList;

	}

	@Override
	public EventDayClick findMallEventDay(String date, String app, String memberId, String mallId, String event) {
		EventDayClick eventDayClick = calculatedDayClickDao.findMallEventDay(date, app, memberId, mallId, event);
		if (eventDayClick == null) {
			eventDayClick = generateDefaultData(date, app, memberId, mallId, event);
		}
		return eventDayClick;
	}

	@Override
	public EventDayClick findMallEventDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId, String event) {
		EventDayClick eventDayClick = calculatedDayClickDao.findMallEventDateRangeSum(startDate, endDate, app, memberId,
				mallId, event);
		if (eventDayClick == null) {
			eventDayClick = generateDefaultData(null, app, memberId, mallId, event);
		}
		return eventDayClick;
	}

	/**
	 * 生成默认数据
	 * 
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 */
	private EventDayClick generateDefaultData(String createDate, String app, String memberId, String mallId,
			String event) {
		EventDayClick eventDayClick = new EventDayClick();
		EventDayClick._Id id = new EventDayClick._Id();
		id.setCreateDate(createDate);
		id.setApp(app);
		id.setMemberId(memberId);
		id.setMallId(mallId);
		id.setEvent(event);

		EventDayClick._Value value = new EventDayClick._Value();
		value.setPv(0D);
		value.setUv(0D);
		value.setIp(0D);

		eventDayClick.setId(id);
		eventDayClick.setValue(value);
		return eventDayClick;
	}
}
