package com.wtoip.analysis.biz.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.wtoip.analysis.biz.dao.CalculatedDayClickVirtualDao;
import com.wtoip.analysis.biz.dao.CalculatedDayVirtualDao;
import com.wtoip.analysis.biz.service.CalculatedDayVirtualService;
import com.wtoip.analysis.biz.util.Constants.DefaultValue;
import com.wtoip.analysis.biz.util.Constants.EventName;
import com.wtoip.analysis.core.framwork.dao.Dao;
import com.wtoip.analysis.core.framwork.service.impl.BaseService;
import com.wtoip.analysis.core.util.DateUtil;
import com.wtoip.analysis.core.util.RandomUtil;
import com.wtoip.analysis.model.CalculatedDayVirtual;
import com.wtoip.analysis.model.EventDayClickVirtual;

/**
 * @Description
 * @author wanghongwei
 * @date 2017年4月5日
 */
@Service("calculatedDayVirtualService")
public class CalculatedDayVirtualServiceImpl extends BaseService<CalculatedDayVirtual>
		implements CalculatedDayVirtualService {

	@Resource
	private CalculatedDayVirtualDao calculatedDayVirtualDao;

	@Resource
	private CalculatedDayClickVirtualDao calculatedDayClickVirtualDao;

	@Override
	protected Dao<CalculatedDayVirtual> getDao() {
		return calculatedDayVirtualDao;
	}

	@Override
	public CalculatedDayVirtual findMallDay(String date, String app, String memberId, String mallId,
			String industryCode1, String industryCode2) {
		CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualDao.findMallDay(date, app, memberId, mallId);
		if (calculatedDayVirtual == null) {
			calculatedDayVirtual = generateDayVirtual(date, app, memberId, mallId, industryCode1, industryCode2);
		}
		return calculatedDayVirtual;
	}

	@Override
	public List<CalculatedDayVirtual> findMallDateRange(String startDate, String endDate, String app, String memberId,
			String mallId, String industryCode1, String industryCode2) throws Exception {
		List<CalculatedDayVirtual> dataList = calculatedDayVirtualDao.findMallDateRange(startDate, endDate, app,
				memberId, mallId);

		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = DateFormat.parse(startDate);
		Date eDate = DateFormat.parse(endDate);
		int days = DateUtil.daysBetween(sDate, eDate) + 1;

		if (days <= dataList.size()) {
			return dataList;
		}

		List<CalculatedDayVirtual> generateDataList = new ArrayList<>(days);
		while (sDate.compareTo(eDate) <= 0) {
			String createDate = DateUtil.getDay(sDate);
			CalculatedDayVirtual calculatedDayVirtual = null;
			for (CalculatedDayVirtual cdv : dataList) {
				if (createDate.equals(cdv.getId().getCreateDate())) {
					calculatedDayVirtual = cdv;
					break;
				}
			}
			if (calculatedDayVirtual == null) {
				calculatedDayVirtual = generateDayVirtual(createDate, app, memberId, mallId, industryCode1,
						industryCode2);
			}

			generateDataList.add(calculatedDayVirtual);

			sDate = DateUtil.addDays(sDate, 1);
		}
		return generateDataList;

	}

	/**
	 * 生成虚拟数据并保存
	 * 
	 * @param date
	 * @param app
	 * @param memberId
	 * @param mallId
	 * @return
	 */
	private CalculatedDayVirtual generateDayVirtual(String date, String app, String memberId, String mallId,
			String industryCode1, String industryCode2) {
		CalculatedDayVirtual calculatedDayVirtual = new CalculatedDayVirtual();
		CalculatedDayVirtual._Id id = new CalculatedDayVirtual._Id();
		id.setCreateDate(date);
		id.setApp(app);
		id.setMemberId(memberId);
		id.setMallId(mallId);
		id.setIndustryCode1(
				industryCode1 == null || "".equals(industryCode1) ? DefaultValue.DEFAULT_INDUSTRY_CODE : industryCode1);
		id.setIndustryCode2(
				industryCode2 == null || "".equals(industryCode2) ? DefaultValue.DEFAULT_INDUSTRY_CODE : industryCode2);

		// (5000~7000随机数)+（真实pv*5）&尾部随机数
		Double pv = Double.valueOf(RandomUtil.getRandom(5000, 7000)) + RandomUtil.getRandom(10);
		EventDayClickVirtual eventDayClickVirtual = calculatedDayClickVirtualDao.findMallEventDay(date, app, memberId,
				mallId, EventName.REFRESHER_NAME);
		// 加上刷新器的曝光量
		if (eventDayClickVirtual != null) {
			pv += eventDayClickVirtual.getValue().getPv();
		}
		Double uv = Double.valueOf(RandomUtil.getRandom(100, 200)) + RandomUtil.getRandom(10);
		CalculatedDayVirtual._Value value = new CalculatedDayVirtual._Value();
		value.setPv(pv);
		value.setUv(uv);
		value.setRpv(0D);

		calculatedDayVirtual.setId(id);
		calculatedDayVirtual.setValue(value);

		calculatedDayVirtualDao.update(calculatedDayVirtual);
		return calculatedDayVirtual;
	}

	@Override
	public CalculatedDayVirtual findMallDateRangeSum(String startDate, String endDate, String app, String memberId,
			String mallId) {
		CalculatedDayVirtual calculatedDayVirtual = calculatedDayVirtualDao.findMallDateRangeSum(startDate, endDate,
				app, memberId, mallId);
		if (calculatedDayVirtual == null) {
			calculatedDayVirtual = new CalculatedDayVirtual();
			CalculatedDayVirtual._Id id = new CalculatedDayVirtual._Id();
			id.setApp(app);
			id.setMemberId(memberId);
			id.setMallId(mallId);

			CalculatedDayVirtual._Value value = new CalculatedDayVirtual._Value();
			value.setPv(0D);
			value.setRpv(0D);
			value.setUv(0D);
			value.setIp(0D);

			calculatedDayVirtual.setId(id);
			calculatedDayVirtual.setValue(value);
		}
		return calculatedDayVirtual;
	}
}
