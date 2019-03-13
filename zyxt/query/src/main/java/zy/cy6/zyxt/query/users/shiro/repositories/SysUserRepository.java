package zy.cy6.zyxt.query.users.shiro.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.users.shiro.SysUser;


/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    SysUser findByAccount(String account);

    Page<SysUser> findAll(Specification<SysUser> sysRoleSpecification, Pageable pageable);
}
