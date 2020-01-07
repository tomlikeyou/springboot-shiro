package com.dy.web.shiro;

import com.dy.entity.Menu;
import com.dy.entity.Role;
import com.dy.entity.User;
import com.dy.service.IMenuService;
import com.dy.service.IRoleService;
import com.dy.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huang
 * @date 2019/10/30 20:19
 * @Disc
 **/
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;

    /*
    授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        List<Role> roles = roleService.getRolesByUserName(userName);

        Set<String> roleNames = Collections.synchronizedSet(new HashSet<>());
        Set<String> perms = Collections.synchronizedSet(new HashSet<>());
        for (Role role : roles) {
            roleNames.add(role.getRoleName());

            List<Menu> menus = menuService.findRolesByRoleId(role.getRoleId());
            for (Menu menu : menus) {
                perms.add(menu.getPerms());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNames);
        info.addStringPermissions(perms);
        return info;
    }

    /*
    认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        } else if (user.getStatus() == "0") {
            throw new LockedAccountException("用户已锁定");
        }
        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), salt, getName());
        return info;
    }

    public static void main(String[] args) {

    }
}
