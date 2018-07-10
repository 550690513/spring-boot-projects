package com.cheung.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 传统项目 整合 quartz 测试类
 *
 * Quartz的使用思路：
 *      1）Job - 任务 - 你要做什么事？
 *      2）Trigger - 触发器 - 你什么时候去做？
 *      3）Scheduler - 任务调度 - 你什么时候需要去做什么事？
 *
 * @author Cheung
 */
public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {

		/**
		 * 1、创建Job对象：任务
		 */
		JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);
		JobDetail job = jobBuilder.build();
		/**
		 * 2、创建Trigger对象：触发器
		 *
		 * SimpleScheduleBuilder：简单的trigger触发时间，通过Quartz提供一个方法来完成简单的重复调用 cron（SimpleScheduleBuilder.repeatSecondlyForever(2)每2秒钟重复一次）
		 * Trigger：按照Cron表达式来给定触发的时间
		 */
		TriggerBuilder<SimpleTrigger> triggerBuilder = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2));
		Trigger trigger = triggerBuilder.build();
		/**
		 * 3、创建Scheduler对象：调度(任务,触发器)
		 */
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);

		// 4、启动
		scheduler.start();

	}

}
