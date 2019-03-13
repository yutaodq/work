package zy.cy6.zyxt.query.users.shiro.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.query.users.shiro.SysRole;
import zy.cy6.zyxt.query.users.shiro.SysUser;
import zy.cy6.zyxt.query.users.shiro.SysUserRole;
import zy.cy6.zyxt.query.users.shiro.enums.REnum;
import zy.cy6.zyxt.query.users.shiro.from.SysUserFrom;
import zy.cy6.zyxt.query.users.shiro.repositories.SysRoleRepository;
import zy.cy6.zyxt.query.users.shiro.repositories.SysUserRepository;
import zy.cy6.zyxt.query.users.shiro.repositories.SysUserRoleRepository;
import zy.cy6.zyxt.query.users.shiro.service.SysUserService;
import zy.cy6.zyxt.query.users.shiro.utils.JPAUtil;
import zy.cy6.zyxt.query.users.shiro.utils.RUtil;
import zy.cy6.zyxt.query.users.shiro.utils.ShiroUtil;
import zy.cy6.zyxt.query.users.shiro.vo.R;
import zy.cy6.zyxt.query.users.shiro.vo.SysUserVo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * author: 小宇宙
 * date: 2018/4/5
 * https://github.com/sherlockgit/SpringBoot-Shrio-jpa
 */
@Service
@Transactional
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    SysRoleRepository sysRoleRepository;

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    public SysUser findByAccount(String account){
       return sysUserRepository.findByAccount(account);
    }

    /**
     * 新增用户
     * @param sysUserFrom
     * @return
     */
    @Override
    public R saveUser(SysUserFrom sysUserFrom) {

        /*判断该账号是否存在*/
        if(sysUserRepository.findByAccount(sysUserFrom.getAccount()) != null){
            log.error(sysUserFrom.getAccount());
           return RUtil.error(REnum.ACCOUNT_EXIST.getCode(),REnum.ACCOUNT_EXIST.getMessage());
        }

        /*分离用户基本信息与其角色*/
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserFrom,sysUser);

        /*生成盐以及加密码并保存*/
        String salt = ShiroUtil.getSalt();
        String md5Password = ShiroUtil.MD5(sysUser.getPassword(),salt);
        sysUser.setPassword(md5Password);
        sysUser.setSalt(salt);
        SysUser sysUserSave = sysUserRepository.save(sysUser);
        log.info("用户基本信息保存：sysUserSave = {}"+sysUserSave);

        /*用户对应角色保存*/
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        sysUserFrom.getSysRoles().forEach(o->{
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUserSave.getId());
            sysUserRole.setRoleId(o.getId());
            sysUserRoles.add(sysUserRole);
        });
        List<SysUserRole> sysUserRolesSave = sysUserRoleRepository.saveAll(sysUserRoles);
        log.info("用户角色保存：sysUserRolesSave = {}"+sysUserRolesSave);
        return RUtil.success();
    }

    /**
     * 查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    @Override
    public R selectUserList(String name, Pageable pageable) {
        Specification<SysUser> specification = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicate = new ArrayList<>();
                if(StringUtils.isNoneBlank(name)){
                    predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
            }
        };
        return RUtil.success(sysUserRepository.findAll(specification,pageable));
    }

    /**
     * 查询用户详情
     * @param id
     * @return
     */
    @Override
    public R selectUserDetail(Integer id) {

        /*查询用户基本信息*/
        SysUserVo sysUserVo = new SysUserVo();
        SysUser sysUser = sysUserRepository.getOne(id);
        BeanUtils.copyProperties(sysUser,sysUserVo);
        sysUserVo.setPassword("*********");
        log.info("用户基本信息：sysUser = {}"+sysUser);

        /*取出角色Id*/
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findByUserId(id);
        List<Integer> sysRoleIds = new ArrayList<>();
        sysUserRoles.forEach(o->{
            sysRoleIds.add(o.getRoleId());
        });

        /*查询该用户用户角色*/
        List<SysRole> sysRoles = sysRoleRepository.findAllById(sysRoleIds);
        log.info("用户角色：sysRoles = {}"+ sysRoles);
        sysUserVo.setSysRoles(sysRoles);
        return RUtil.success(sysUserVo);
    }

    /**
     * 更新用户
     * @param sysUserFrom
     * @return
     */
    @Override
    public R updateUser(SysUserFrom sysUserFrom) {

        /*判断用户有没有修改账号*/
        if(!sysUserRepository.getOne(sysUserFrom.getId()).getAccount().equals(sysUserFrom.getAccount())){
            /*用户修改账号*/

            /*判断该账号是否存在*/
            if(sysUserRepository.findByAccount(sysUserFrom.getAccount()) != null){
                log.error(sysUserFrom.getAccount());
                return RUtil.error(REnum.ACCOUNT_EXIST.getCode(),REnum.ACCOUNT_EXIST.getMessage());
            }
        }
        /*账号未修改*/

        /*分离用户与其拥有角色*/
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserFrom,sysUser);

        /*初始化密码与盐并保存*/
        String salt = ShiroUtil.getSalt();
        String md5Password = ShiroUtil.MD5(sysUser.getPassword(),salt);
        sysUser.setPassword(md5Password);
        sysUser.setSalt(salt);
        SysUser sysUserSave = sysUserRepository.save(sysUser);
        log.info("用户更新：sysUserSave = {}"+ sysUserSave);

        /*初始化用户角色*/
        sysUserRoleRepository.deleteByUserId(sysUserFrom.getId());

        /*添加用户角色*/
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        sysUserFrom.getSysRoles().forEach(o->{
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(o.getId());
            sysUserRole.setUserId(sysUserFrom.getId());
            sysUserRoles.add(sysUserRole);
        });
        List<SysUserRole> sysUserRolesSave = sysUserRoleRepository.saveAll(sysUserRoles);
        log.info("用户角色：sysUserRolesSave = {}"+sysUserRolesSave);
        return RUtil.success();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public R delectUser(Integer id) {
        sysUserRoleRepository.deleteByUserId(id);
        sysUserRepository.deleteById(id);
        return RUtil.success();
    }
}
