package com.wtoip.analysis.core.util;

import java.util.UUID;

/**
 * @Description:
 * @author wanghongwei
 * @date: 2017年3月20日
 */
public class UUIDUtil {
	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
