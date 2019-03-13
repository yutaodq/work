package zy.cy6.zyxt.query.users.shiro.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import zy.cy6.zyxt.query.users.shiro.SysResource;

import java.util.List;

/**
 * author: 小宇宙
 * date: 2018/4/7
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色等级
     */
    private Integer grade;

    /**
     * 备注
     */
    private String remark;

    /**
     * 拥有资源
     */
    private List<SysResource> sysResources;
}
