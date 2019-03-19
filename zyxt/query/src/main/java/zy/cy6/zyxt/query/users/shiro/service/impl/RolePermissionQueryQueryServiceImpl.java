package zy.cy6.zyxt.query.users.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zy.cy6.zyxt.query.users.shiro.entity.Permission;
import zy.cy6.zyxt.query.users.shiro.entity.RolePermission;
import zy.cy6.zyxt.query.users.shiro.repository.PermissionRepository;
import zy.cy6.zyxt.query.users.shiro.repository.RolePermissionRepository;
import zy.cy6.zyxt.query.users.shiro.service.RolePermissionQueryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author - langhsu
 * @create - 2018/5/18
 */
@Service
public class RolePermissionQueryQueryServiceImpl implements RolePermissionQueryService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Permission> findPermissions(long roleId) {
        List<RolePermission> rps = rolePermissionRepository.findAllByRoleId(roleId);

        List<Permission> rets = null;
        if (rps != null && rps.size() > 0) {
            Set<Long> pids = new HashSet<>();
            rps.forEach(rp -> pids.add(rp.getPermissionId()));
            rets = permissionRepository.findAllById(pids);
        }
        return rets;
    }

    @Override
    @Transactional
    public void deleteByRoleId(long roleId) {
        rolePermissionRepository.deleteByRoleId(roleId);
    }

    @Override
    @Transactional
    public void add(Set<RolePermission> rolePermissions) {
        rolePermissionRepository.saveAll(rolePermissions);
    }
}
