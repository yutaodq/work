package zy.cy6.zyxt.query.users.shiro.service;


import zy.cy6.zyxt.query.users.shiro.entity.Permission;
import zy.cy6.zyxt.query.users.shiro.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * @author - langhsu
 * @create - 2018/5/18
 */
public interface RolePermissionQueryService {
    List<Permission> findPermissions(long roleId);
    void deleteByRoleId(long roleId);
    void add(Set<RolePermission> rolePermissions);

}
