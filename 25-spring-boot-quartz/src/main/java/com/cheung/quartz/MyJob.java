package com.cheung.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 自定义Job任务类 --> 须实现org.quartz.Job接口
 *
 * @author Cheung
 */
public class MyJob implements Job {

	/**
	 * 任务被触发时，所执行的方法
	 *
	 * @param jobExecutionContext
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("MyJob is executed..." + new Date());
	}

}
