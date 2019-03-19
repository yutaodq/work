package zy.cy6.zyxt.query.users.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import zy.cy6.zyxt.query.users.shiro.base.utils.Consts;
import zy.cy6.zyxt.query.users.shiro.data.AccountProfile;
import zy.cy6.zyxt.query.users.shiro.data.UserVO;
import zy.cy6.zyxt.query.users.shiro.entity.Role;
import zy.cy6.zyxt.query.users.shiro.service.UserRoleQueryService;
import zy.cy6.zyxt.query.users.shiro.service.UserQueryService;

import java.util.List;

public class AccountRealm extends AuthorizingRealm {
  @Autowired private UserQueryService userQueryService;
  @Autowired private UserRoleQueryService userRoleQueryService;

  public AccountRealm() {
    super(new AllowAllCredentialsMatcher());
    setAuthenticationTokenClass(UsernamePasswordToken.class);
  }
  /**
   * 获取授权信息
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    /**
     * long userId = Optional.ofNullable(getCurrentUser()).map(user -> user.getId()).orElse(null)
     */
    AccountProfile profile = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    if (profile != null) {
      UserVO user = userQueryService.get(profile.getId());
      if (user != null) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = userRoleQueryService.listRoles(user.getId());

        //赋予角色
        roles.forEach(role -> {
          info.addRole(role.getName());

          //赋予权限
          role.getPermissions().forEach(permission -> info.addStringPermission(permission.getName()));
        });
        return info;
      }
    }
    return null;
  }
  private AccountProfile getCurrentUser() {
    return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
  }
  /**
   * 认证验证（返回数据库中真实的用户名、密码）
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    AccountProfile profile = getAccount(userQueryService, token);

    if (profile.getStatus() == Consts.STATUS_CLOSED) {
      throw new LockedAccountException(profile.getName());
    }
    SimpleAuthenticationInfo info =
        new SimpleAuthenticationInfo(profile, token.getCredentials(), getName());
    Session session = SecurityUtils.getSubject().getSession();
    session.setAttribute("profile", profile);
    return info;
  }

  protected AccountProfile getAccount(UserQueryService userQueryService, AuthenticationToken token) {
    UsernamePasswordToken upToken = (UsernamePasswordToken) token;
    return userQueryService.login(upToken.getUsername(), String.valueOf(upToken.getPassword()));
  }
}
