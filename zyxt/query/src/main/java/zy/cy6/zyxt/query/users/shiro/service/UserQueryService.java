/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package zy.cy6.zyxt.query.users.shiro.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zy.cy6.zyxt.query.users.shiro.data.AccountProfile;
import zy.cy6.zyxt.query.users.shiro.data.UserVO;

import java.util.Map;
import java.util.Set;

/**
 * @author langhsu
 *
 */
//@CacheConfig(cacheNames = Consts.CACHE_USER)
public interface UserQueryService {
	/**
	 * 分页查询
	 * @param pageable
	 * @param name
	 */
	Page<UserVO> paging(Pageable pageable, String name);

	Map<Long, UserVO> findMapByIds(Set<Long> ids);

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	AccountProfile login(String username, String password);

	/**
	 * 登录,用于记住登录时获取用户信息
	 * @param id
	 * @return
	 */
	AccountProfile findProfile(Long id);

	/**
	 * 注册
	 * @param user
	 */
	UserVO register(UserVO user);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@CacheEvict(key = "#user.getId()")
	AccountProfile update(UserVO user);

	/**
	 * 查询单个用户
	 * @param userId
	 * @return
	 */
	@Cacheable(key = "#userId")
	UserVO get(long userId);

	UserVO getByUsername(String username);

	/**
	 * 修改密码
	 * @param id
	 * @param newPassword
	 */
	void updatePassword(long id, String newPassword);

	/**
	 * 修改密码
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	void updatePassword(long id, String oldPassword, String newPassword);

	/**
	 * 修改用户状态
	 * @param id
	 * @param status
	 */
	void updateStatus(long id, int status);

	long count();

}
