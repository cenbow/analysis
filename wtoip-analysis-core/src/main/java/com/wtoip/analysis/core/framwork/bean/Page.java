package com.wtoip.analysis.core.framwork.bean;

import java.io.Serializable;
import java.util.Arrays;

/** 
 *  @Description:简单分页对象
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
public class Page implements Serializable {
	
	private static final long serialVersionUID = 710290672655076891L;
	
	/**
	 * 每页显示记录数
	 */
    private Integer rows;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 总记录数
     */
    private Long totalResult;
    /**
     * 当前记录起始索引
     */
    private Integer currentResult;
    /**
     * 排序字段
     */
    private String[] sort;
    /**
     * ASC or DESC
     */
    private String[] order;
    /**
     * 是否计算总数（默认不计算）
     */
    private Boolean count = false;
    
    public Page setTotalPage(Long totalPage) { 
        this.totalPage = totalPage;
        return this;
    }
    
    public Page setTotalResult(Long totalResult) {
        this.totalResult = totalResult;
        return this;
    }
    
    public Page setPage(Integer page) {
        this.page = page;
        return this;
    }
    
    public Page setCurrentResult(Integer currentResult) {
        this.currentResult = currentResult;
        return this;
    }
    
    public Page setRows(Integer rows) {
		this.rows = rows;
		return this;
	}
   
	public Page setSort(String[] sort) {
		this.sort = sort;
		return this;
	}
	
	public Page setCount(Boolean count) {
		this.count = count;
		return this;
	}
	
	/**
	 * @param order the order to set
	 */
	public void setOrder(String[] order) {
		this.order = order;
	}
    public Boolean isCount() {
		return count;
	}
    
    public Long getTotalPage() {
    	if (totalResult % rows==0)
            totalPage = totalResult / rows;
        else
            totalPage = totalResult / rows + 1;
        return totalPage;
    }
    
    public Long getTotalResult() {
        return totalResult;
    }
    
    public Integer getCurrentPage() {
        return page<=0 ? 1:page;
    }
    
    public Integer getCurrentResult() {
        currentResult = (getCurrentPage() - 1) * rows;
        return currentResult<0 ? 0:currentResult; 
    }
   
	public Integer getRows() {
		return rows;
	}

	/**
	 * @return the sort
	 */
	public String[] getSort() {
		return sort;
	}

	/**
	 * @return the order
	 */
	public String[] getOrder() {
		return order;
	}

	public Integer getPage() {
		return page;
	}

	/**
	 * @return the count
	 */
	public Boolean getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return "Page [rows=" + rows + ", page=" + page + ", totalPage=" + totalPage + ", totalResult=" + totalResult
				+ ", currentResult=" + currentResult + ", sort=" + Arrays.toString(sort) + ", order="
				+ Arrays.toString(order) + ", count=" + count + "]";
	}
	
}
