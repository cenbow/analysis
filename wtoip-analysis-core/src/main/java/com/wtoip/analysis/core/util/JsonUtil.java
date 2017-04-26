package com.wtoip.analysis.core.util;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月30日
 */
public class JsonUtil {

	private static ObjectMapper mapper;
	
	static{
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object obj) throws Exception{
		return mapper.writeValueAsString(obj); 
	}
	
	/**
	 * 
	 * @param content
	 * @param cls
	 * @return
	 * @throws Exception
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toBean(String content,Class<T> cls) throws Exception{
		return mapper.readValue(content, cls);
	}
}
