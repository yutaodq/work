package zy.cy6.zyxt.query.users.shiro.service;

import org.springframework.data.domain.Pageable;
import zy.cy6.zyxt.query.users.shiro.SysUser;
import zy.cy6.zyxt.query.users.shiro.from.SysUserFrom;
import zy.cy6.zyxt.query.users.shiro.vo.R;


/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysUserService {

    SysUser findByAccount(String account);

    R saveUser(SysUserFrom sysUserFrom);

    R selectUserList(String name, Pageable pageable);

    R selectUserDetail(Integer id);

    R updateUser(SysUserFrom sysUserFrom);

    R delectUser(Integer id);
}
