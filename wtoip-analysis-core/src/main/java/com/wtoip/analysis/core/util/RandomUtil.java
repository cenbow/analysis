package com.wtoip.analysis.core.util;

import java.util.Random;

/** 
 *  @Description
 *	@author wanghongwei
 *  @date   2017年4月5日
 */
public class RandomUtil {

	/**
	 * 获取范围类的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandom(int min, int max){
		return new Random().nextInt(max-min) + min;
	}
	
	/**
	 * 
	 * @param max
	 * @return
	 */
	public static int getRandom(int max){
		return new Random().nextInt(max);
	}
}
