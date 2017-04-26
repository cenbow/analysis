package com.wtoip.analysis.biz.util;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月21日
 */
public final class Constants {
	
	public interface EventName{
		/**
		 * 缓存命名空间
		 */
		public static final String CACHE_NAMESPACE = "analysis_";
		/**
		 * 商品名称
		 */
		public static final String GOODS_NAME = "GOODS_PAGE";
		/**
		 * 刷新器
		 */
		public static final String REFRESHER_NAME = "REFRESHER_CLICK";
	}
	
	public interface CacheName{
		/**
		 * namespace
		 */
		public static final String CACHE_NAMESPACE = "analysis";
		/**
		 * 事件缓存key
		 */
		public static final String EVENT_CACHE_NAME = "eventCache";
		/**
		 * 分页缓存key
		 */
		public static final String PAGE_CACHE_NAME = "pageCache";
	}
	
	public interface CollectionName{
		
		/**
		 * 原始数据数据表
		 */
		public static final String ACCESS = "access";
		/**
		 * 原始数据数据表
		 */
		public static final String ACCESS_CLICK = "access_click";
		/**
		 * 原始数据数据表
		 */
		public static final String ORDER = "order";
		/**
		 * 以天为单位统计表
		 */
		public static final String CALCULATE_DAY = "calculated_day";
		/**
		 * 以天为单位统计表(虚拟数据)
		 */
		public static final String CALCULATED_DAY_VIRTUAL = "calculated_day_virtual";
		/**
		 * 以店铺-页面(事件)维度统计表
		 */
		public static final String CALCULATED_EVENT_DAY = "calculated_event_day";
		/**
		 * 以店铺-页面(事件)维度统计表
		 */
		public static final String EVENT_DAY_CLICK = "event_day_click";
		/**
		 * 以店铺-页面(事件)维度统计表(虚拟数据)
		 */
		public static final String EVENT_DAY_CLICK_VIRTUAL = "event_day_click_virtual";
		
		/**
		 * 以天为单位统计表(虚拟数据)
		 */
		public static final String SHOP_DESIGN = "shop_design";
		
		/**
		 * 以天为单位统计订单
		 */
		public static final String ORDER_DAY = "order_day";
		/**
		 * 以天为单位统计商品销量
		 */
		public static final String ORDER_TRADE_DAY = "order_trade_day";
	}
	
	public interface DefaultValue{
		/**
		 * 
		 */
		public static final String DEFAULT_MEMBERID = "0";
		/**
		 * 
		 */
		public static final String DEFAULT_MALLID = "0";
		/**
		 * 
		 */
		public static final String DEFAULT_INDUSTRY_CODE = "0";
	}
	
}
