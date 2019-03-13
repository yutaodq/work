package zy.cy6.zyxt.query.users.shiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.users.shiro.SysUserRole;

import java.util.List;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer>{

    List<SysUserRole> findByUserId(Integer id);

    void deleteByUserId(Integer id);
}
