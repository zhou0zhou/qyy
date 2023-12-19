package com.ccnu.controller;

import com.ccnu.entity.Follower;
import com.ccnu.entity.Topic;
import com.ccnu.entity.User;
import com.ccnu.service.FollowerService;
import com.ccnu.service.ManageTopicService;
import com.ccnu.service.SendTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sendtopic")
public class TopicController {
    @Autowired
    private SendTopicService sendtopicservice;
    @Autowired
    private ManageTopicService managetopicservice;

    @PostMapping("/t")
    public String tosendtopic() {
        return "sendtopic.html";
    }

    @PostMapping("/t1")
    public String publishtopics(String title, String content, String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User login = (User) session.getAttribute("user");
        String account = login.getAccount();
        int i = sendtopicservice.publish(title, content, account, name);
        if (i != 0) {
            return "homepage.html";
        }
        return "sendtopic.html";
    }

    @PostMapping("/t2")
    public String tomytopic(Model model,HttpServletRequest request){
        HttpSession session=request.getSession();
        User login= (User) session.getAttribute("user");

        String account= login.getAccount();
        List<Topic> list=sendtopicservice.findmyAll(login);
//        String s="";
//        for(Topic topic:list){
//            s+=topic.toString();
//            s+="<br>";
//        }
        model.addAttribute("message",list);
        return "mytopic.html";
    }
    @RequestMapping(value = "/findall",method = {RequestMethod.GET,RequestMethod.POST})
    public String toalltopic(Model model){
        List<Topic> topics = managetopicservice.findAll();
        model.addAttribute("topics", topics);
        return "alltopic.html";
    }
    @GetMapping("/t3")
    public String delete(@RequestParam("topic_title") String topic_title){
        managetopicservice.delete(topic_title);
        return "homepage.html";
    }
//    @GetMapping("/t4")
//    public String update(Topic topic){
//        managetopicservice.update(topic);
//        return "homepage.html";

    @PostMapping("/message")
    @ResponseBody
    public String like(@RequestParam("like") String like,@RequestParam("titles") String title){
        Integer likes = Integer.parseInt(like);
        likes+=1;
//        System.out.println(like);
//        System.out.println(title);
        sendtopicservice.likes(title,likes);
        String s= String.valueOf(likes);
        return s;
    }

}