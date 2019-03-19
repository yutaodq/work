/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package zy.cy6.zyxt.query.users.shiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.users.shiro.entity.User;

/**
 * @author langhsu
 */
public interface MyAccountRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
