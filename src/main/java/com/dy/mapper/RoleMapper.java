package com.dy.mapper;

import com.dy.entity.Role;

import java.util.List;

/**
 * @author huang
 * @date 2019/10/31 15:01
 * @Disc
 **/
public interface RoleMapper {

    List<Role> selectRolesBy(Role role);

    int deleteRole(Integer roleId);

    int updateRole(Role role);

    int insertRole(Role role);

    List<Role> getRolesByUserName(String userName);
}
