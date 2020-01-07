package com.dy.service;

import com.dy.entity.Menu;

import java.util.List;

/**
 * @author 黄俊
 * @date 2019/11/5 22:14
 * @Disc
 **/
public interface IMenuService {
    List<Menu> findAllMenu();

    Menu queryById(Integer menuId);

    List<Menu> findRolesByRoleId(Integer roleId);
}
