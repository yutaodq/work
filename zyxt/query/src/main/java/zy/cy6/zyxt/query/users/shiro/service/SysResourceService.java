package zy.cy6.zyxt.query.users.shiro.service;

import com.sherlock.premssion.model.SysResource;

import java.util.Set;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysResourceService {

    Set<String> selectUserPerms(Integer userId);

}
