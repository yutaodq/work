package zy.cy6.zyxt.query.users.shiro.service;

import org.springframework.data.domain.Pageable;
import zy.cy6.zyxt.query.users.shiro.from.SysRoleFrom;
import zy.cy6.zyxt.query.users.shiro.vo.R;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysRoleService {

    R saveRole(SysRoleFrom sysRoleFrom);

    R selectRoleList(String name, Pageable pageable);

    R selectRoleDetail(Integer id);

    R updateRole(SysRoleFrom sysRoleFrom);

    R deleteRole(Integer id);
}
