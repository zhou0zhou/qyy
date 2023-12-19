package com.ccnu.controller;

import com.ccnu.service.ManageUserService;
import com.ccnu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manageuser")
public class ManageUserController {
    @Autowired
    private ManageUserService manageUserService;

    //查询所有
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<User> users = manageUserService.findAll();
        model.addAttribute("users", users);
        return "/userlist";
    }
    //保存员工
    @PostMapping("/save")
    public String save(User user){
        manageUserService.save(user);
        return "redirect:/manageuser/findAll";
    }

    //删除用户
    @GetMapping("/delete")
    public String delete(@RequestParam("account") String account){
        manageUserService.delete(account);
        return "redirect:/manageuser/findAll";
    }

    //更新员工信息
    @PostMapping("/update")
    public String update(User user){
        manageUserService.update(user);
        return "redirect:/manageuser/findAll";
    }

    @PostMapping("/update2")
    public String update2(User user){
        manageUserService.update2(user);
        return "redirect:/index";
    }

    //根据账号查询员工信息
    @GetMapping("/find")
    public String find(String account, Model model) {
        User user = manageUserService.find(account);
        model.addAttribute("user", user);
        return "updateuser";
    }

}
