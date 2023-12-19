package com.ccnu.controller;

import com.ccnu.entity.User;
import com.ccnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")  //命名空间
public class UserController {
    @Autowired
    private UserService userService;

    //注册方法
    @PostMapping("/register")
    public String register(User user, HttpSession session){
            userService.register(user);
            return "redirect:/index";//跳转到登陆页面
        }

    //登陆方法
    @GetMapping("/goHome")
    public String goHome(HttpSession session,HttpServletRequest request) {
        session=request.getSession();
        if (session != null) {
            return "homepage.html";           //登录成功则跳转到主页
        } else {
            return "redirect:/index";           //跳转到登录页面（重新登录）
        }
    }


    //登陆方法
    @PostMapping("/login")
    public String login(String account, String password,HttpSession session,HttpServletRequest request) {
        User login = userService.login(account, password);
        session=request.getSession();
        if (login != null) {
            session.setAttribute("user", login);
            return "homepage.html";           //登录成功则跳转到主页
        } else {
            return "redirect:/index?sign=loginFailed";           //跳转到登录页面（重新登录）
        }
    }
    //找回密码方法
    @PostMapping("/forgetpassword")
    public String forgetpassword(String account, String security_answer, HttpSession session){
        User forgetpassword = userService.forgetpassword(account, security_answer);
        if (forgetpassword!=null){
            session.setAttribute("user",forgetpassword);
            forgetpassword.setPassword("123456");
            // 更新用户密码
            userService.updatePassword(forgetpassword);
            // 将修改后的用户对象保存到会话中
            session.setAttribute("user", forgetpassword);
            return "modifypassword";           //匹配成功则跳转到提示页面
        }else{
            return "redirect:/index";           //匹配失败则返回登录界面
        }
    }

    @PostMapping("/toPersonalcenter")
    public String personalcenter(HttpSession session, Model model) {
        User updatedUser = (User) session.getAttribute("user");
        userService.update(updatedUser);
        String account = updatedUser.getAccount();
        model.addAttribute("account", account);
        return "personalcenter.html";
    }

    //更新员工信息
    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/toPersonalcenter";
    }

    @PostMapping("/update2")
    public String update2(User user){
        userService.update2(user);
        return "redirect:/index";
    }

    //根据账号查询员工信息
    @GetMapping("/find")
    public String find(String account, Model model) {
        User user = userService.find(account);
        model.addAttribute("user", user);
        return "updateuser2";
    }

    @GetMapping("/feedback")
    public String feedback(String account, Model model) {
        User user = userService.feedback(account);
        model.addAttribute("user", user);
        return "feedback";
    }




}
