package zy.cy6.zyxt.query.users.shiro.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import zy.cy6.zyxt.query.users.shiro.SysRole;

import java.util.List;

/**
 * author: 小宇宙
 * date: 2018/4/7
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUserVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否禁用 0：否；1：是
     */
    private String forbidden;

    /**
     * 用户角色
     */
    private List<SysRole> sysRoles;
}
