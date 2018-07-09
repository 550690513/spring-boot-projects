package com.cheung.service.impl;

import com.cheung.dao.UserJpaRepository;
import com.cheung.pojo.User;
import com.cheung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService接口实现类
 *
 * @author Cheung
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	@Cacheable(value = "user")
	public User findUserById(Integer id) {
		return this.userJpaRepository.findOne(id);
	}

	/**
	 * @Cacheable 把方法的返回值添加到Ehcache中做缓存处理
	 *          value = "user"：缓存名称。指定使用配置文件中name="user"的自定义缓存策略，若不配置value，则使用默认缓存策略。
	 *          key = "#pageable"：缓存的key。key可为空。若不指定,则默认按照方法的所有参数进行组合；若要指定则必须按照SpEL表达式编写(即以"#"开头)；
	 * <p>
	 * 错误示例：（在test中演示）
	 * 此处若以“pageable对象的pageSize属性作为缓存的key”，
	 * 则只要pageable对象的pageSize值未发生变化时（key未改变），Ehcache都会默认该缓存存在，直接读取缓存来使用；
	 * 当且仅当pageabe对象的pageSize属性值发生变化时，Ehcache才会去重新查库。
	 */
	@Cacheable(value = "user", key = "#pageable")
	// @Cacheable(value = "user", key = "#pageable.pageSize")
	@Override
	public Page<User> findUserByPage(Pageable pageable) {
		return this.userJpaRepository.findAll(pageable);
	}

	@Override
	@Cacheable(value = "user")
	public List<User> findUserAll() {
		return this.userJpaRepository.findAll();
	}

	/**
	 *
	 * @CacheEvict 清除缓存
	 *        value = "user"：指定清除缓存中以"user"缓存策略来缓存的对象
	 *        allEntries：是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
	 */
	@Override
	@CacheEvict(value = "user", allEntries = true)
	public void saveUser(User user) {
		this.userJpaRepository.save(user);
	}

}
