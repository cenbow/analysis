package org.wtoip.analysis.core.util;

import com.wtoip.analysis.core.framwork.bean.ResponseResult;
import com.wtoip.analysis.core.util.JsonUtil;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年3月30日
 */
public class JsonUtilTest {

	public static void main(String[] args) throws Exception {
	 	String json = JsonUtil.toJson(ResponseResult.newInstance().success().message("请求成功"));
	 	System.out.println(json);
	}
	
}
