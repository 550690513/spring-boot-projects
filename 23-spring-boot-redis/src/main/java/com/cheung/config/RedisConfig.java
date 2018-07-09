package com.cheung.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 完成对Redis的整合相关配置
 *
 * @author Cheung
 */
// Spring boot在启动时,对于用@Configuration注解的类,会去立即加载,同时,去执行该类下所有用@Bean注解的方法.
@Configuration// spring boot配置注解
public class RedisConfig {

	/**
	 * 1.创建JedisPoolConfig对象,完成一些连接池配置
	 *
	 * @ConfigurationProperties(prefix = "myRedisConfig"):会将前缀名相同的内容创建一个实体,不同部分作为该实体的属性
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		/*
		// 最大空闲数
		config.setMaxIdle(10);
		// 最小空闲数
		config.setMinIdle(5);
		// 最大连接数
		config.setMaxTotal(20);
		*/

		System.out.println("默认最大空闲数: " + config.getMaxIdle());
		System.out.println("默认最小空闲数: " + config.getMinIdle());
		System.out.println("默认最大连接数: " + config.getMaxTotal());
		return config;
	}

	/**
	 * 2.创建jedisConnectionFactory,配置redis连接信息
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {

		System.out.println("默认最大空闲数: " + config.getMaxIdle());
		System.out.println("默认最小空闲数: " + config.getMinIdle());
		System.out.println("默认最大连接数: " + config.getMaxTotal());

		JedisConnectionFactory factory = new JedisConnectionFactory();
		/*
		// 关联连接池
		factory.setPoolConfig(config);
		// 配置连接redis的信息
		factory.setHostName("localhost");
		factory.setPort(6379);
		factory.setDatabase(15);// 默认0-15
		*/
		return factory;
	}

	/**
	 * 3.创建redisTemplate,用于执行redis操作的方法
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		// 关联
		template.setConnectionFactory(factory);
		// 为key设置序列化器(则key可以为任意类型了...)
		template.setKeySerializer(new StringRedisSerializer());
		// 为value设置序列化器(则value可以为任意类型了...)
		template.setValueSerializer(new StringRedisSerializer());

		return template;
	}

}
