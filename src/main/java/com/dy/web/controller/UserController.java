package com.dy.web.controller;

import com.dy.entity.AjaxResult;
import com.dy.entity.Dept;
import com.dy.entity.User;
import com.dy.service.IDeptService;
import com.dy.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangjun
 * @date 2019/10/30 17:53
 * @Disc
 **/
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @Autowired
    private IDeptService deptService;

    /*@RequestMapping(value = "/findUsersWithLike")
    public String findUsers(Model model, User user) {
        List<User> users = userService.findUsersWithLike(user);
        List<String> status = userService.findStatus();
        List<Dept> depts = deptService.findDepts();
        model.addAttribute("users", users);
        model.addAttribute("statuses", status);
        model.addAttribute("depts", depts);
        return "user/userList";
    }*/

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String findWithPage(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Model model,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "status", required = false) String status,
                               @RequestParam(value = "deptId", required = false) Integer deptId) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("userName",userName);
        paramsMap.put("status",status);
        paramsMap.put("deptId",deptId);
        PageInfo<User> userPageInfo = userService.selectPage(pageNo, 5,paramsMap);
        List<String> statuses = userService.findStatus();
        List<Dept> depts = deptService.findDepts();
        model.addAttribute("users", userPageInfo);
        model.addAttribute("statuses", statuses);
        model.addAttribute("depts", depts);
        return "user/userList";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable(value = "userId") Integer userId) {
        User user = userService.findUserById(userId);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(Model model, User user) {
        int updateFlag = userService.updateUser(user);
        if (updateFlag > 0) {
            return "redirect:/users";
        } else {
            model.addAttribute("msg", "更新失败，重试");
            return "/user/userUpdate";
        }
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public String delUser(@PathVariable("userId") Integer userId, Model model) {
        int deleteFlag = userService.delUser(userId);
        if (deleteFlag > 0) {
            return "redirect:/users";
        } else {
            model.addAttribute("msg", "删除失败，请重试");
            return "/user/userList";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Model model, User user) {
        int update = userService.insertUser(user);
        System.out.println(update);
        System.out.println(user.getUserId());
        AjaxResult result = new AjaxResult(update > 0 ? true : false, user.getUserId());
        return result;
    }


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/login")
    public String login(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
            try {
                subject.login(token);
                return "redirect:/main";
            } catch (UnknownAccountException uae) {
                logger.error(uae.getMessage());
                model.addAttribute("msg", "用户名不存在");
                return "forward:toLogin";
            } catch (IncorrectCredentialsException ice) {
                System.out.println(ice.getMessage());
                model.addAttribute("msg", "密码不正确");
                return "forward:toLogin";
            } catch (LockedAccountException lae) {
                System.out.println(lae.getMessage());
                model.addAttribute("msg", "账户已锁定");
                return "forward:toLogin";
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
                model.addAttribute("msg", "未知错误");
                return "forward:toLogin";
            }
        }
        return "forward:toLogin";
    }

    @RequestMapping("/unauth")
    public String unauth() {
        return "/unAuth";
    }

    @RequestMapping("/logout")
    public void exit() {
    }
}