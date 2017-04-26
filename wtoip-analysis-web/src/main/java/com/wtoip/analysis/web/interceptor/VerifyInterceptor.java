package com.wtoip.analysis.web.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.util.VerifyUtil;

/**
 * @Description:
 * @author wanghongwei
 * @date: 2017年3月22日
 */
public class VerifyInterceptor implements HandlerInterceptor {
	
	public static String SECURITY_KEY = "wtoip2017@)!&";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Map<String, String[]> rqParams = request.getParameterMap();
		
		if(!rqParams.containsKey(VerifyUtil.VERIFY_KEY_NAME)){
			throw new BaseException("Invalid request:not fuond verifyKey");
		}
		if(!rqParams.containsKey(VerifyUtil.TIMESTAMP_NAME)){
			throw new BaseException("Invalid request:not fuond timestamp");
		}
		
		Map<String, String> params = new HashMap<>();
		
		for(Map.Entry<String, String[]> entry : rqParams.entrySet()){
			params.put(entry.getKey(), entry.getValue()[0]);
		}
		
		String verifyKey = params.remove(VerifyUtil.VERIFY_KEY_NAME);
		
		Long timestamp = Long.parseLong(params.get(VerifyUtil.TIMESTAMP_NAME));
		
		Long currTimestamp = System.currentTimeMillis();
		
		Long time = Math.abs(currTimestamp-timestamp);
		
		if(time > 60000){
			throw new BaseException("Invalid request:time out");
		}
		
		String currVerifyKey = VerifyUtil.getVerifyKey(params,SECURITY_KEY);
		
		if(!verifyKey.equals(currVerifyKey)){
			throw new BaseException("Invalid request:verifyKey error");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
