package com.dy.service.impl;

import com.dy.entity.Role;
import com.dy.mapper.RoleMapper;
import com.dy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄俊
 * @date 2019/10/31 15:00
 * @Disc
 **/
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRolesBy(Role role) {
        return roleMapper.selectRolesBy(role);
    }

    @Override
    public int deleteRole(Integer roleId) {
        return roleMapper.deleteRole(roleId);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);

    }

    @Override
    public List<Role> getRolesByUserName(String userName) {
        return roleMapper.getRolesByUserName(userName);
    }
}
