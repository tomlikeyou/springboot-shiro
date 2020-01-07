package com.dy.web.controller;

import com.dy.entity.Role;
import com.dy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huang
 * @date 2019/10/31 14:56
 * @Disc
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findRolesLike")
    public String findRolesLike(Role role, Model model) {
        List<Role> roles = roleService.findRolesBy(role);
        model.addAttribute("roles", role);
        return "/role/roleList";
    }

    @RequestMapping("/update")
    public String updateRole(Role role, Model model) {
        int updateFlag = roleService.updateRole(role);
        if (updateFlag > 0) {
            return "redirect:/findRolesLike";
        } else {
            model.addAttribute("msg", "更新失败，重试一下吧");
            return "/role/roleList";
        }
    }

    @RequestMapping("add")
    public String addRole(Role role, Model model) {
        int addFlag = roleService.insertRole(role);
        if (addFlag > 0) {
            return "redirect:/findRolesLike";
        } else {
            model.addAttribute("msg", "添加失败，重试一下吧");
            return "/role/roleAdd";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Integer deleteRole(Integer roleId) {
        int deleteFlag = roleService.deleteRole(roleId);
        return deleteFlag;
    }
}
