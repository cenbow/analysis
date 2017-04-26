package com.wtoip.analysis.core.framwork.spring.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.wtoip.analysis.core.framwork.bean.Page;
import com.wtoip.analysis.core.framwork.bean.PageResult;
import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.framwork.spring.annotation.PageCache;

/**
 * @Description 缓存分页(必须包含Page对象并且返回类型为PageResult<T>)
 * 第一页加载所有数据(代理方法不能做分页处理),后续分页数据从缓存中读取
 * @author wanghongwei
 * @date   2017年3月24日
 */
@Aspect
public class PageCacheAspect extends AbstrackCacheAspect {
	
	private String cacheName;

	/**
	 * @return the cacheName
	 */
	public String getCacheName() {
		return cacheName;
	}

	/**
	 * @param cacheName the cacheName to set
	 */
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	@Around("@annotation(cache)")
	private Object doAround(ProceedingJoinPoint pjp, PageCache cache) throws Throwable {
		// 查找page对象
		Page page = null;
		Object[] args = pjp.getArgs();
		if (args != null) {
			for (Object arg : args) {
				if (arg instanceof Page) {
					page = (Page) arg;
				}
			}
		}
		//没有找到page参数
		if (page == null) {
			throw new BaseException("not found page");
		}
		//返回值
		Object reVal = null;
		if (localCache == null) {
			log.warn("not found localCache");
			reVal = pjp.proceed();
			return getPageData(page,reVal);
		}
		//获取缓存key
		String key = getKey(pjp, cache.value());
		if (key == null) {
			log.warn("not found cache key");
			reVal = pjp.proceed();
			return getPageData(page,reVal);
		}
		//第一页重新加载
		if (page.getCurrentPage() == 1 && cache.loadPageOne()) {
			log.debug("execute method");
			reVal = pjp.proceed();
			try{
				//设置缓存
				localCache.put(namespace, cacheName, key, reVal);
				log.debug("set data to cache==>"+key+":"+reVal);
			}catch(Exception e){
				log.error("set data to cache faild:"+key,e);
			}
			return getPageData(page,reVal);
		}
		try{
			reVal = localCache.get(namespace, cacheName, key);
			log.debug("get data from cache==>"+key+":"+reVal);
		}catch(Exception e){
			log.error("get data from cache faild:"+key,e);
		}
		
		if(reVal == null){
        	log.debug("execute method");
        	reVal = pjp.proceed();
        	try{
				//设置缓存
				log.debug("set data to cache==>"+key+":"+reVal);
				localCache.put(namespace, cacheName, key, reVal);
			}catch(Exception e){
				log.error("set data to cache faild:"+key,e);
			}
        }
		
		return getPageData(page,reVal);
	}

	/**
	 * 分页处理
	 * @param page
	 * @param reVal
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> PageResult<T> getPageData(Page page,Object reVal){
		PageResult<T> result = (PageResult<T>)reVal;
		
		List<T> dataList = (List<T>) result.getData();
		if(dataList==null || dataList.size()==0){
			page.setTotalResult(0L);
			result.setPage(page);
			return result;
		}
		
		page.setTotalResult(Long.valueOf(dataList.size()));
		
		int currPage = page.getPage();
		//如果当前页大于pagesize
		if(currPage>page.getTotalPage()){
			result.setData(new ArrayList<T>());
			result.setPage(page);
			return result;
		}
		
		int start = page.getCurrentResult();
		int end = page.getCurrentResult()+page.getRows();
		if(end > dataList.size()){
			end = dataList.size();
		}
		
		List<T> reList = new ArrayList<>(dataList.subList(start, end));
		
		return new PageResult<T>().setPage(page).setData(reList);
	}
	
}
