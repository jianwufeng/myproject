package com.crm.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.crm.domain.user.SysMenuLimitDO;
import com.crm.domain.user.UserDO;

@Service
public class UserRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired
    // private UserServiceAO userServiceAo;
    //
    // @Autowired
    // private UserRoleServiceAO urServiceAO;
    //
    // @Autowired
    // private RoleServiceAO roleServiceAO;
    //
    // @Autowired
    // private RoleMenuServiceAO roleMenuServiceAO;
    //
    // @Autowired
    // private SysMenuServiceAO sysMenuServiceAO;
    //
    // @Autowired
    // private RoleMenuLimitServiceAO roleMenuLimitServiceAO;
    //
    // @Autowired
    // private SysMenuLimitServiceAO sysMenuLimitServiceAO;

    /**
     * @principals 用户凭证 ,登录成功后的用户信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        UserDO user = (UserDO) principals.getPrimaryPrincipal();

        Long roleId = 11L;// this.urServiceAO.getRoleIdByUserId(user.getId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (null != roleId) {
            List<Long> sysMenuIdsList = new ArrayList<Long>(); // this.roleMenuServiceAO.selectSysMenuIds(roleId);

            logger.debug(sysMenuIdsList.toString());
            if (null != sysMenuIdsList && !sysMenuIdsList.isEmpty()) {
                List<SysMenuLimitDO> list = null;
                if (null != sysMenuIdsList && !sysMenuIdsList.isEmpty()) {
                    list = new ArrayList<SysMenuLimitDO>();
                    for (Long menuId : sysMenuIdsList) {

                        List<SysMenuLimitDO> smList = new ArrayList<SysMenuLimitDO>();// ;this.sysMenuLimitServiceAO.findBySysMenuId(menuId);
                        list.addAll(smList);
                    }
                }

                Set<String> perSet = new HashSet<String>();
                for (SysMenuLimitDO menu : list) {
                    if (StringUtils.isEmpty(menu.getPermission())) {
                        continue;
                    }
                    perSet.add(menu.getPermission());
                }
                authorizationInfo.setStringPermissions(perSet);
            }
        }
        return authorizationInfo;
    }

    /**
     * @token 用户登录信息(令牌)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();
        logger.info("[BEGIN]用户登录:" + loginName);

        UserDO user = null;
        try {
            // user = userServiceAo.findByLoginName(loginName);
            logger.debug("[SUCCESS]登录时获取用户信息:" + user.toString());
        } catch (Exception e) {
            logger.error("[ERROR]登录时获取用户信息错误:" + e.getMessage(), e.getMessage());
        }
        if (null == user) {
            throw new UnknownAccountException();// 没找到帐号
        }
        logger.debug("[BEGIN]获取用户信息:" + user.toString());

        if (Boolean.FALSE.equals(user.getState())) {
            throw new LockedAccountException(); // 帐号锁定
        }

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, // 用户名
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),// salt=loginName+salt
                getName() // realm name
        );

        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(final PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(final PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(final PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    /**
     * 清空授权缓存
     *
     * @param principals
     * @param userName
     */
    public void clearUserCachedInfo(final PrincipalCollection principals, final String userName) {
        // if (null != userName) {
        // super.getAuthenticationCache().remove(userName);
        // return;
        // }
        // UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        // if (null != userDO) {
        // super.getAuthenticationCache().remove(userDO.getLoginName());
        // }
    }

    /**
     * 清空用户缓存
     *
     * @param principals
     * @param userName
     */
    /*
     * public void clearUserCachedAuthenticationInfo(PrincipalCollection principals,String userName) { if(null !=
     * userName){ super.getAuthorizationCache().keys().remove(userName); return; } UserDO userDO =
     * (UserDO)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(); if(null != userDO){
     * super.getAuthorizationCache().remove(userDO.getLoginName()); } }
     */

}
