package com.dy.web.controller;

import com.dy.entity.Menu;
import com.dy.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huang
 * @date 2019/11/5 22:10
 * @Disc
 **/
@Controller
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> findAllMenu() {
        List<Menu> menus = menuService.findAllMenu();

        List<Menu> menulist = new ArrayList<>();
        Map<Integer, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            menuMap.put(menu.getMenuId(), menu);
        }
        for (Menu menu : menus) {
            Menu child = menu;
            if (child.getParentId() == 0) {
                menulist.add(child);
            } else {
                Menu parent = menuMap.get(child.getParentId());
                parent.getChildrenList().add(child);
            }
        }
        return menulist;
    }

    public String edit(Integer menuId, Model model) {
        Menu menu = menuService.queryById(menuId);
        model.addAttribute("menu", menu);
        return "menu/menuList";
    }
}
