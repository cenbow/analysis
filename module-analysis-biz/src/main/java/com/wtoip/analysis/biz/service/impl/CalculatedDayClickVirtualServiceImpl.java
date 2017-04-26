package com.wtoip.analysis.biz.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wtoip.analysis.biz.dao.CalculatedDayClickVirtualDao;
import com.wtoip.analysis.biz.service.CalculatedDayClickVirtualService;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.model.EventDayClickVirtual;

/**
 * @Description
 * @author wanghongwei
 * @date 2017年4月6日
 */
@Service("calculatedDayClickVirtualService")
public class CalculatedDayClickVirtualServiceImpl extends BaseService<EventDayClickVirtual>
		implements CalculatedDayClickVirtualService {

	@Resource
	private CalculatedDayClickVirtualDao calculatedDayClickVirtualDao;

	@Override
	protected Dao<EventDayClickVirtual> getDao() {
		return calculatedDayClickVirtualDao;
	}

	@Override
	public EventDayClickVirtual findMallEventDay(String date, String app, String memberId, String mallId,
			String event) {
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualDao.findMallEventDay(date, app, memberId,
				mallId, event);
		if (eventDayClickVirtual == null) {
			eventDayClickVirtual = generateDayClickVirtual(date, app, memberId, mallId, event);
		}
		return eventDayClickVirtual;
	}

	@Override
	public List<EventDayClickVirtual> findMallEventDateRange(String startDate, String endDate, String app,
			String memberId, String mallId, String event) throws Exception {
		List<EventDayClickVirtual> dataList = calculatedDayClickVirtualDao.findMallEventDateRange(startDate, endDate,
				app, memberId, mallId, event);

		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = DateFormat.parse(startDate);
		Date eDate = DateFormat.parse(endDate);
		int days = DateUtil.daysBetween(sDate, eDate) + 1;

		if (days <= dataList.size()) {
			return dataList;
		}

		List<EventDayClickVirtual> generateDataList = new ArrayList<>(days);
		while (sDate.compareTo(eDate) <= 0) {
			String createDate = DateUtil.getDay(sDate);
			EventDayClickVirtual eventDayClickVirtual = null;
			for (EventDayClickVirtual edv : dataList) {
				if (createDate.equals(edv.getId().getCreateDate())) {
					eventDayClickVirtual = edv;
					break;
				}
			}
			if (eventDayClickVirtual == null) {
				eventDayClickVirtual = generateDayClickVirtual(createDate, app, memberId, mallId, event);
			}

			generateDataList.add(eventDayClickVirtual);

			sDate = DateUtil.addDays(sDate, 1);
		}
		return generateDataList;

	}

	@Override
	public EventDayClickVirtual findMallEventDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId, String event) {
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualDao.findMallEventDateRangeSum(startDate,
				endDate, app, memberId, mallId, event);
		if (eventDayClickVirtual == null) {
			eventDayClickVirtual = new EventDayClickVirtual();
			EventDayClickVirtual._Id id = new EventDayClickVirtual._Id();
			id.setApp(app);
			id.setMemberId(memberId);
			id.setMallId(mallId);
			id.setEvent(event);
			EventDayClickVirtual._Value value = new EventDayClickVirtual._Value();
			value.setPv(0D);
			value.setUv(0D);
			value.setIp(0D);
			eventDayClickVirtual.setId(id);
			eventDayClickVirtual.setValue(value);
		}
		return eventDayClickVirtual;
	}

	/**
	 * 生成虚拟数据并保存
	 * 
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @param event
	 * @return
	 */
	private EventDayClickVirtual generateDayClickVirtual(String date, String app, String memberId, String mallId,
			String event) {
		EventDayClickVirtual eventDayClickVirtual = new EventDayClickVirtual();
		EventDayClickVirtual._Id id = new EventDayClickVirtual._Id();
		id.setCreateDate(date);
		id.setApp(app);
		id.setMemberId(memberId);
		id.setMallId(mallId);
		id.setEvent(event);

		EventDayClickVirtual._Value value = new EventDayClickVirtual._Value();
		value.setPv(0D);

		eventDayClickVirtual.setId(id);
		eventDayClickVirtual.setValue(value);

		return eventDayClickVirtual;
	}

}
