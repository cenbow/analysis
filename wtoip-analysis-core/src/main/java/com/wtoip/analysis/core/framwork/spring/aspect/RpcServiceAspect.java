package com.wtoip.analysis.core.framwork.spring.aspect;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcException;
import com.wtoip.analysis.core.framwork.exception.BaseCodeException;
import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.util.Constants.ErrorCode;

/** 
 *  @Description rpc异常处理
 *	@author wanghongwei
 *  @date   2017年3月31日
 */
public class RpcServiceAspect {

	private Logger log = LoggerFactory.getLogger(RpcServiceAspect.class);
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		if(log.isInfoEnabled()){
			Object[] args = pjp.getArgs();
			if(args != null && args.length > 0){
				String methodName = pjp.getSignature().getName();
				String className = pjp.getTarget().getClass().getName();
				
				StringBuilder sb = new StringBuilder();
				sb.append(className)
				.append(".")
				.append(methodName)
				.append("(");
				for(Object arg : args){
					sb.append(arg).append(",");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append(")");
				log.info(sb.toString());
			}
		}
		try{
			return pjp.proceed();
		}catch(Exception ex){
			Integer errcode;
			String errorMsg;
			
			Throwable baseEx = ExceptionUtils.getRootCause(ex);
			if(baseEx == null){
				baseEx = ex;
			}
			
			if(baseEx instanceof BaseCodeException){
				errcode = ((BaseCodeException)baseEx).getErrcode();
				errorMsg = ex.getMessage();
				log.info(errorMsg,ex);
			}else if(baseEx instanceof BaseException){
				errcode = ErrorCode.SYSTEM_ERROR;
				errorMsg = ex.getMessage();
				log.info(errorMsg,ex);
			}else if(baseEx instanceof RpcException){
				errcode = ((RpcException)baseEx).getCode();
				errorMsg = ex.getMessage();
				log.error(errorMsg,ex);
			}else{
				errcode = ErrorCode.SYSTEM_ERROR;
				errorMsg = "系统异常，请稍后再试!";
				log.error(ex.getMessage(),ex);
			}
			throw new RpcException(errcode,errorMsg);
		}
	}
	
}
