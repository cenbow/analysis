package com.wtoip.analysis.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.wtoip.analysis.core.framwork.exception.BaseException;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月27日
 */

public class DateUtil {
	/**
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getDay(Date date){
		return DateFormatUtils.format(date, "yyyy-MM-dd");
	}
	
	/**
	 * yyyy-MM-dd
	 * @param calendar
	 * @return
	 */
	public static String getDay(Calendar calendar){
		return DateFormatUtils.format(calendar, "yyyy-MM-dd");
	}
	
	/**
	 * HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getTime(Date date){
		return DateFormatUtils.format(date, "HH:mm:ss");
	}
	
	/**
	 * HH:mm:ss
	 * @param calendar
	 * @return
	 */
	public static String getTime(Calendar calendar){
		return DateFormatUtils.format(calendar, "HH:mm:ss");
	}
	
	/**
	 * HH
	 * @param date
	 * @return
	 */
	public static String getHour(Date date){
		return DateFormatUtils.format(date, "HH");
	}
	
	/**
	 * HH
	 * @param calendar
	 * @return
	 */
	public static String getHour(Calendar calendar){
		return DateFormatUtils.format(calendar, "HH");
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int daysBetween(Date startDate, Date endDate){
		return (int)((endDate.getTime()-startDate.getTime())/(1000*3600*24)) ;
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Date addDays(Date date, int days){
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,days);
		return calendar.getTime();
	}
	
	public static Date parseYYYY_MM_dd(String date){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new BaseException(e.getMessage(),e);
		}
	}
}
