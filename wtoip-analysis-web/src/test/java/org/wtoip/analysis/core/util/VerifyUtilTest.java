package org.wtoip.analysis.core.util;

import java.util.HashMap;
import java.util.Map;

import com.wtoip.analysis.core.util.VerifyUtil;
import com.wtoip.analysis.web.interceptor.VerifyInterceptor;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月12日
 */
public class VerifyUtilTest {

	public static void main(String[] args) {
		Long currTimestamp = System.currentTimeMillis();
		Map<String, String> params = new HashMap<>();
		params.put("timestamp", currTimestamp+"");
		params.put("date", "2017-04-10");
		
		String verifyKey = VerifyUtil.getVerifyKey(params,VerifyInterceptor.SECURITY_KEY);
		
		System.out.println("timestamp="+currTimestamp+"&verifyKey="+verifyKey);
	}
	
}
