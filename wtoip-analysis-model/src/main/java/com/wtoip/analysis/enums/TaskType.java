package com.wtoip.analysis.enums;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
public enum TaskType {
	CALCULATED_DAY,//店铺pv,uv
	CALCULATED_DAY_VIRTUAL,//店铺虚拟pv,uv
	CALCULATED_EVENT_DAY,//店铺事件pv,uv
	CALCULATED_EVENT_DAY_VIRTUAL,//店铺事件虚拟pv,uv
	MALL_DESIGN_TOP,//店铺装修排行
	MALL_PV_TOP,//店铺曝光排行
	MALL_TRADE_TOP,//店铺交易排行
	CALCULATED_ORDER_DAY,//店铺交易订单
	CALCULATED_ORDER_TRADE_DAY,//店铺商品统计
	ONE_TIME//一次性任务
}
