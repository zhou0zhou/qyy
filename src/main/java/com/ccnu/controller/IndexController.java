package com.ccnu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 * @author icu
 * @create 2023-06-30
 */
@Controller
public class IndexController {

    //经过控制器
    @GetMapping("/index")
    public String toIndex() {
        return "/login";
    }

    //从/login点Regist按钮跳转到/toRegister 从而到/regist
    @GetMapping("/toRegister")
    public String toRegister() {
        return "/regist";
    }

    @GetMapping("/toSave")
    public String toSave() {
        return "/addtopic";
    }

    @GetMapping("/toManage")
    public String managePage() {return "/manage";}

    @GetMapping("/toForgetpassword")
    public String forgetpassword() {return "/forgetpassword";}
}