package com.dy.web.controller;

import com.dy.entity.Dept;
import com.dy.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang
 * @date 2019/10/31 15:41
 * @Disc
 **/
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/find")
    public String findAllDept(Model model) {
        return "dept/deptList";
    }

    @RequestMapping("/modify")
    public String updateDept(Dept dept, Model model) {
        int updateFlag = deptService.updateDept(dept);
        if (updateFlag > 0) {
            return "redirect:/find";
        } else {
            model.addAttribute("msg", "修改失败，哪里出错了 ");
            return "dept/deptList";
        }
    }

    @RequestMapping(value = "/delete/{deptId}", method = RequestMethod.DELETE)
    @ResponseBody
    public int modify(@PathVariable("deptId") Integer deptId) {
        int updateFlag = deptService.delDept(deptId);
        return updateFlag;
    }

    @RequestMapping("/add")
    public String addDept(Dept dept, Model model) {
        int insertFlag = deptService.addDept(dept);
        if (insertFlag > 0) {
            return "redirect:/find";
        } else {
            model.addAttribute("msg", "添加失败，哪里出错了 ");
            return "dept/deptList";
        }
    }
}
