package com.dy.service;

import com.dy.entity.Menu;
import com.dy.entity.Role;

import java.util.List;

/**
 * @author 黄俊
 * @date 2019/10/31 15:00
 * @Disc
 **/
public interface IRoleService {
    List<Role> findRolesBy(Role role);

    int deleteRole(Integer roleId);

    int updateRole(Role role);

    int insertRole(Role role);

    List<Role> getRolesByUserName(String userName);
}
