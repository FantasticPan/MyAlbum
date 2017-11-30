package com.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 李攀 on 2017/11/24.
 */
@Controller
public class IndexController {

    @RequestMapping("/index.do")
    public String index() {
        return "index";
    }

    @RequestMapping("/home.do")
    public String home() {
        return "home";
    }
}
