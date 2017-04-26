package com.wtoip.analysis.biz.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtoip.analysis.biz.service.TaskService;
import com.wtoip.analysis.core.framwork.exception.BaseException;
import com.wtoip.analysis.core.framwork.lock.DLock;
import com.wtoip.analysis.core.framwork.lock.DLockFactory;
import com.wtoip.analysis.core.util.UUIDUtil;
import com.wtoip.analysis.enums.TaskStatus;
import com.wtoip.analysis.enums.TaskType;
import com.wtoip.analysis.model.Task;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月21日
 */
public abstract class BaseTask {

	private Logger log = LoggerFactory.getLogger(BaseTask.class);
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private DLockFactory dLockFactory;
	
	//60秒
	public static final Long LOCK_TIMEOUT = 60l;
	
	/**
	 * 
	 * @param type 任务类型
	 * @param period 任务周期
	 * @param param 参数
	 * @param checkOn 检查任务是否已执行,已执行的忽略
	 * @param rollBack 回调函数
	 */
	protected void _execute(TaskType type,String period,Object param,boolean checkOn,RollBack rollBack){
		String lockName = type + "_" + period;
		
		DLock lock = dLockFactory.getRedisLock(lockName);
		
		Task task = new Task();
		task.setId(UUIDUtil.getUUID());
		task.setType(type);
		task.setStatus(TaskStatus.EXECUTING);
		task.setExecTime(new Date());
		task.setPeriod(period);
		task.setParams(param);
		try {
			if(checkOn && lock.tryLock(LOCK_TIMEOUT, TimeUnit.SECONDS)){
				Task currTask = taskService.findByTypeAndPeriod(type, period);
				if(currTask != null){
					log.info("task has already run:type={},period={}",type,period);
					return;
				}
			}
			taskService.insert(task);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}finally{
			try{
				if(checkOn){
					lock.unlock();
				}
			}catch(Exception e){
				log.error(e.getMessage(),e);
			}
		}
		
		try{
			log.info("task run:type={},period={},params={}",type,period,param);
			
			rollBack.rollBack();
			
			task.setStatus(TaskStatus.SUCCESS);
			task.setFinishTime(new Date());
			task.setSpendTime(task.getFinishTime().getTime()-task.getExecTime().getTime());
			
			taskService.update(task);
		}catch(Exception e){
			String errorMsg;
			if(e instanceof BaseException){
				errorMsg = e.getMessage();
				log.info(errorMsg,e);
			}else{
				errorMsg = ExceptionUtils.getStackTrace(e);
				log.error(e.getMessage(),e);
			}
			
			task.setStatus(TaskStatus.FAIL);
			task.setErrMsg(errorMsg);
			task.setFinishTime(new Date());
			task.setSpendTime(task.getFinishTime().getTime()-task.getExecTime().getTime());
			taskService.update(task);
		}
	}
	
	protected interface RollBack{
		
		/**
		 * 回调
		 */
		void rollBack() throws Exception;
		
	}
	
}
