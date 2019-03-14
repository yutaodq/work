package zy.cy6.zyxt.query.users.shiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zy.cy6.zyxt.query.users.shiro.entity.RolePermission;

import java.util.List;

/**
 * @author - langhsu
 * @create - 2018/5/18
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long>, JpaSpecificationExecutor<RolePermission> {
    int deleteByRoleId(long roleId);
    List<RolePermission> findAllByRoleId(long roleId);
}
