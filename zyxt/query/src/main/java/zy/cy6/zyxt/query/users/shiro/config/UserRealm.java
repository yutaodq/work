package zy.cy6.zyxt.query.users.shiro.config;

import com.sherlock.premssion.enums.ForbiddenEnum;
import com.sherlock.premssion.enums.REnum;
import com.sherlock.premssion.model.SysUser;
import com.sherlock.premssion.repository.SysResourceRepository;
import com.sherlock.premssion.service.SysResourceService;
import com.sherlock.premssion.service.SysUserService;
import com.sherlock.premssion.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.net.www.protocol.http.AuthenticationInfo;

/**
 * 认证与授权规则
 * author: 小宇宙
 * date: 2018/4/5
 */
@Slf4j
@Component
public class UserRealm extends AuthorizingRealm{

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysResourceService sysResourceService;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(sysResourceService.selectUserPerms(ShiroUtil.getUserId()));
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        SysUser sysUser = sysUserService.findByAccount(token.getUsername());
        if(sysUser == null){
            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+sysUser);
            throw new UnknownAccountException();
        }
        if(ForbiddenEnum.DISABLE.getCode().toString().equals(sysUser.getForbidden())){
            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+sysUser);
            throw new DisabledAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getSalt()));
        return simpleAuthenticationInfo;
    }

    /**
     * 密码验证服务
     * @param credentialsMatcher
     */
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5HashedCredentialsMatcher = new HashedCredentialsMatcher();
        md5HashedCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
        md5HashedCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
        md5HashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        super.setCredentialsMatcher(md5HashedCredentialsMatcher);
    }
}
