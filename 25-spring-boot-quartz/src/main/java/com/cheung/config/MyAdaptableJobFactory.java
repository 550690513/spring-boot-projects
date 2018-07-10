package com.cheung.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * Spring Boot 定时任务，job类对象的注入
 *
 * @author Cheung
 */
@Component("myAdaptableJobFactory")// 在spring中实例化该类
public class MyAdaptableJobFactory extends AdaptableJobFactory {

	/**
	 * AutowireCapableBeanFactory：可以将一个对象手动添加到springIOC容器中，并完成该对象的注入
	 */
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	/**
	 * 重写该方法
	 * 1、需要将实例化的任务对象手动添加到springIOC容器中，并且完成对象的注入；
	 *
	 * @param bundle
	 * @return
	 * @throws Exception
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object jobInstance = super.createJobInstance(bundle);
		// 将jobInstance对象手动添加到springIOC容器中，并完成对象注入
		this.autowireCapableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}

}
