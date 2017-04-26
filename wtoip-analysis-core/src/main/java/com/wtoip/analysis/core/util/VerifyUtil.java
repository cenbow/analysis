package com.wtoip.analysis.core.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.util.DigestUtils;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月22日
 */
public class VerifyUtil {
	
	public static final String VERIFY_KEY_NAME = "verifyKey";
	
	public static final String TIMESTAMP_NAME = "timestamp";
	
	/**
	 * 获取校验key
	 * @param params
	 * @return
	 */
	public static String getVerifyKey(Map<String, String> params,String securityKey){
		Map<String, String> sortedMap = new TreeMap<>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				return obj1.compareTo(obj2);
			}
		});
		
		sortedMap.putAll(params);
		
		StringBuilder sbVerify = new StringBuilder();
		
		for(Map.Entry<String, String> entry : sortedMap.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			
			sbVerify.append(key).append("=").append(value).append("&");
		}
		sbVerify.append(securityKey);
		
		return  DigestUtils.md5DigestAsHex(sbVerify.toString().getBytes());
	}

}
