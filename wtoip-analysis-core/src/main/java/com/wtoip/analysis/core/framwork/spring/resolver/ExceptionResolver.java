package com.wtoip.analysis.core.framwork.spring.resolver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.wtoip.analysis.core.framwork.exception.BaseCodeException;
import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.util.Constants.ErrorCode;


/** 
 *  @Description:简单异常处理
 *	@author wanghongwei
 *  @date:   2017年3月17日
 */
public class ExceptionResolver implements HandlerExceptionResolver {

	private Logger log = LoggerFactory.getLogger(ExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		Integer errcode;
		String errorMsg;
		
		Throwable baseEx = ExceptionUtils.getRootCause(ex);
		if(baseEx == null){
			baseEx = (Throwable)ex;
		}
		
		if(baseEx instanceof BaseCodeException){
			errcode = ((BaseCodeException)baseEx).getErrcode();
			errorMsg = ex.getMessage();
			log.info(errorMsg,ex);
		}else if(baseEx instanceof BaseException){
			errcode = ErrorCode.SYSTEM_ERROR;
			errorMsg = ex.getMessage();
			log.info(errorMsg,ex);
		}else{
			errcode = ErrorCode.SYSTEM_ERROR;
			errorMsg = "系统异常，请稍后再试!";
			log.error(ex.getMessage(),ex);
		}
		
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("code",errcode);
		attributes.put("message",errorMsg);
		
		jsonView.setAttributesMap(attributes);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(jsonView);
		
		return modelAndView;
	}

}
