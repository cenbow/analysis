package com.wtoip.analysis.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import com.wtoip.analysis.enums.TaskStatus;
import com.wtoip.analysis.enums.TaskType;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:   2017年3月20日
 */
@Document(collection = "task")
public class Task implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private String id;
	/**
	 * 任务类型
	 */
	private TaskType type;
	/**
	 * 任务状态
	 */
	private TaskStatus status;
	/**
	 * 任务参数对象
	 */
	private Object params;
	/**
	 * 错误信息
	 */
	private String errMsg;
	/**
	 * 执行周期
	 */
	private String period;
	/**
	 * 耗时(单位：毫秒)
	 */
	private Long spendTime;
	/**
	 * 执行时间
	 */
	private Date execTime;
	/**
	 * 完成时间
	 */
	private Date finishTime;
	/**
	 * @return the type
	 */
	public TaskType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TaskType type) {
		this.type = type;
	}
	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	/**
	 * @return the params
	 */
	public Object getParams() {
		return params;
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Object params) {
		this.params = params;
	}
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	/**
	 * @return the spendTime
	 */
	public Long getSpendTime() {
		return spendTime;
	}
	/**
	 * @param spendTime the spendTime to set
	 */
	public void setSpendTime(Long spendTime) {
		this.spendTime = spendTime;
	}
	/**
	 * @return the execTime
	 */
	public Date getExecTime() {
		return execTime;
	}
	/**
	 * @param execTime the execTime to set
	 */
	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}
	/**
	 * @return the finishTime
	 */
	public Date getFinishTime() {
		return finishTime;
	}
	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", type=" + type + ", status=" + status + ", params=" + params + ", errMsg=" + errMsg
				+ ", period=" + period + ", spendTime=" + spendTime + ", execTime=" + execTime + ", finishTime="
				+ finishTime + "]";
	}
}
