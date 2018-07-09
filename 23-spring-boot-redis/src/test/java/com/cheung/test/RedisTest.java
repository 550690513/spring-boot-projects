package com.cheung.test;

import com.cheung.App;
import com.cheung.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring-data-redis测试类
 *
 * @author Cheung
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class RedisTest {

	/**
	 * spring boot启动时,RedisConfig.java被加载,且内部@Bean注解的方法均被执行了
	 * 所以,最后返回的RedisTemplate<K,V>已经在spring的IOC容器当中了
	 */
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 测试set一条数据
	 */
	@Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("23-spring-boot-redis", "https://github.com/550690513");
	}

	/**
	 * 测试get一条数据
	 */
	@Test
	public void testGet() {
		String val = (String) this.redisTemplate.opsForValue().get("23-spring-boot-redis");
		System.out.println(val);
	}

	/**
	 * 测试存入一个User对象
	 */
	@Test
	public void testSetUser() {
		User user = new User("张三丰", 800, "武当山");
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());// value采用jdk序列化器序列化的方式
		this.redisTemplate.opsForValue().set("user", user);
	}

	/**
	 * 测试取出一个User对象
	 */
	@Test
	public void testGetUser() {
		// 不能直接读取,因为直接读取的是乱码的序列化后的字节的字符
		// User user = (User) this.redisTemplate.opsForValue().get("user");

		// 应该先执行反序列化(必须重新设置value的序列化器)
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());// value采用jdk序列化器序列化的方式
		User user = (User) this.redisTemplate.opsForValue().get("user");
		System.out.println(user.toString());
	}


	/**
	 * 测试基于Json格式来存入一个User对象
	 */
	@Test
	public void testSetUserUseJson() {
		User user = new User("李四丰", 1000, "武当山2");
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));// value采用Json序列化器序列化的方式
		this.redisTemplate.opsForValue().set("user2", user);
	}

	/**
	 * 测试读取Json格式的User对象
	 */
	@Test
	public void testGetUserUseJson() {
		// 不能直接读取,因为直接读取的是乱码的序列化后的字节的字符
		// User user = (User) this.redisTemplate.opsForValue().get("user");

		// 应该先执行反序列化(必须重新设置value的序列化器)
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));// value采用Json序列化器序列化的方式
		User user = (User) this.redisTemplate.opsForValue().get("user2");
		System.out.println(user.toString());
	}

}
