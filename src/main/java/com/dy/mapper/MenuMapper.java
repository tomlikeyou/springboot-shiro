package com.dy.mapper;

import com.dy.entity.Menu;

import java.util.List;

/**
 * @author huang
 * @date 2019/11/5 22:15
 * @Disc
 **/
public interface MenuMapper {

    List<Menu> findAllMenu();

    Menu queryById(Integer menuId);

    List<Menu> findRolesByRoleId(Integer roleId);
}
