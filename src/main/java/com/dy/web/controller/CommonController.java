package com.dy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄俊
 * @date 2019/11/6 16:27
 * @Disc
 **/
@Controller
public class CommonController {
    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }
}
