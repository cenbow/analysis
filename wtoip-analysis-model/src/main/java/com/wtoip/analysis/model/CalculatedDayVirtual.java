package com.wtoip.analysis.model;

import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
@Document(collection = "calculated_day_virtual")
public class CalculatedDayVirtual extends CalculatedDay{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
