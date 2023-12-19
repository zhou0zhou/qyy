package com.ccnu.controller;
import com.ccnu.service.ManageTopicService;
import com.ccnu.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/managetopic")
public class ManageTopicController {
    @Autowired
    private ManageTopicService manageTopicService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Topic> topics = manageTopicService.findAll();
        model.addAttribute("topics", topics);
        return "topiclist";
    }

    // 保存员工
    @PostMapping("/save")
    public String save(Topic topic){
        manageTopicService.save(topic);
        return "redirect:/managetopic/findAll";
    }

    // 删除话题
    @GetMapping("/delete")
    public String delete(@RequestParam("topic_title") String topic_title){
        manageTopicService.delete(topic_title);
        return "redirect:/managetopic/findAll";
    }

    // 更新话题信息
    @PostMapping("/update")
    public String update(Topic topic){
        manageTopicService.update(topic);
        return "redirect:/managetopic/findAll";
    }

    // 根据账号查询话题信息
    @GetMapping("/find")
    public String find(@RequestParam("topic_title") String topic_title, Model model) {
        Topic topic = manageTopicService.find(topic_title);
        model.addAttribute("topic",topic);
        return "updatetopic";
    }

}
