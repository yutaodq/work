package zy.cy6.zyxt.query.users.shiro.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import zy.cy6.zyxt.query.users.shiro.SysRole;


/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

    Page<SysRole> findAll(Specification<SysRole> sysRoleSpecification, Pageable pageable);
}
