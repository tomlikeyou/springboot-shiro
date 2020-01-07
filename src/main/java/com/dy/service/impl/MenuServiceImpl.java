package com.dy.service.impl;

import com.dy.entity.Menu;
import com.dy.mapper.MenuMapper;
import com.dy.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄俊
 * @date 2019/11/5 22:14
 * @Disc
 **/
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> rootmenu = menuMapper.findAllMenu();
        return rootmenu;
        /*//先找到一级菜单
        for (int i = 0; i < rootmenu.size(); i++) {
            Menu menu = rootmenu.get(i);
            if (menu.getParentId() != null && menu.getParentId() == 0) {
                menulist.add(menu);
            }
        }
        for (Menu menu : menulist) {
            menu.setChildrenList(getchild(menu.getMenuId(), rootmenu));
        }
        return menulist;*/
    }

    @Override
    public Menu queryById(Integer menuId) {
        return menuMapper.queryById(menuId);
    }

    @Override
    public List<Menu> findRolesByRoleId(Integer roleId) {
        return menuMapper.findRolesByRoleId(roleId);
    }

   /* private List<Menu> getchild(Integer menuId, List<Menu> rootmenu) {
        List<Menu> childlist = new ArrayList<>();
        for (Menu menu : rootmenu) {
            if (menu.getParentId().equals(menuId)) {
                childlist.add(menu);
            }
        }
        //
        for (Menu menu : childlist) {
            menu.setChildrenList(getchild(menu.getMenuId(), childlist));
        }
        if (childlist.size() == 0) {
            return null;
        }
        return childlist;
    }*/
}
