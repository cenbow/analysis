package com.wtoip.analysis.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public class AccessAllowInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "*");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Credentials","true");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
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
