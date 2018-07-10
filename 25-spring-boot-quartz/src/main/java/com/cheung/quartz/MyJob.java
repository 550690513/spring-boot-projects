package com.cheung.quartz;

import com.cheung.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 自定义Job任务类 --> 须实现org.quartz.Job接口
 *
 * @author Cheung
 */
public class MyJob implements Job {

	/**
	 * 实际开发中，当在自定义任务类中注入对象时，会产生空指针异常；
	 * 原因：
	 *      因为在QuartzConfig.java中，MyJob类的实例化是靠JobDetailFactoryBean来完成的，
	 *      实际上是由AdaptableJobFactory.createJobInstance()来完成的，而查看其源码发现是利用反射机制来完成，
	 *      在此过程中直接将实例化的任务对象返回了，并未将该实例化的任务对象添加到springIOC容器中，更没有完成对象的注入，所以会产生空指针异常；
	 * 解决：
	 *      1、自定义类继承AdaptableJobFactory类，重写其createJobInstance()方法，在方法中，先手动将该实例化的任务对象添加到springIOC容器中，并完成对象的注入，再将对象返回；
	 *      2、在自定义类上添加@Component()注解，在spring中实例化该类
	 *      3、在QuartzConfig.schedulerFactoryBean()方法中，对schedulerFactoryBean对象重新设置JobFactoryBean为自定义的MyAdaptableJobFactory，即：schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
	 * 		   让SchedulerFactoryBean去调用spring创建的MyAdaptableJobFactory，进而调用其重写后的createJobInstance()方法，完成将实例化的任务对象添加到springIOC容器，并且完成对象的注入
	 */
	@Autowired
	private UserService userService;

	/**
	 * 任务被触发时，所执行的方法
	 *
	 * @param jobExecutionContext
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("MyJob is executed..." + new Date());
		this.userService.addUser();
	}

}
