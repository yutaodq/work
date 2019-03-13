package zy.cy6.zyxt.query.users.shiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.users.shiro.SysResource;
import zy.cy6.zyxt.query.users.shiro.SysRoleResource;

import java.util.List;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysResourceRepository extends JpaRepository<SysResource,Integer> {
    List<SysResource> findByRoleId(List<Integer> roleIds);
}
