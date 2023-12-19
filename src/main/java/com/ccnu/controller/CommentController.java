package com.ccnu.controller;

import com.ccnu.entity.Comment;
import com.ccnu.entity.User;
import com.ccnu.service.SendCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private SendCommentService sendcommentservice;
    @GetMapping("/c")
    public String tosendcomment(@RequestParam("title") String title,HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("title",title);
        return "sendcomment.html";
    }
    @RequestMapping (value = "/c1",method = {RequestMethod.GET,RequestMethod.POST})
    public String sendcomment( String content, HttpServletRequest request){
        HttpSession session= request.getSession();
        User login=(User)session.getAttribute("user");
        String title= (String) session.getAttribute("title");
        String account=login.getAccount();
        int i= sendcommentservice.send(title,content,account);
        return "redirect:/sendtopic/findall";
    }
    @GetMapping("/c2")
    public String allcoment(HttpServletRequest request, Model model,@RequestParam("title") String title){
        HttpSession session=request.getSession();
        List<Comment> list=sendcommentservice.allcomment(title);
        String s="";
        int i=1;
        s+="<ul>";
        for(Comment comment:list){
            s+="<li style='border-bottom: 1px dashed;font-family: fangsong;font-size: 16px;margin-top: 18px;'>";
            s+="评论";
            s+=i;
            s+="<br>";
            s+=comment.tostring();
            i+=1;
            s+="<br><br>";
            s+="</li>";
        }
        s+="</ul>";
        model.addAttribute("message",s);
        return "allcomment.html";
    }
}
