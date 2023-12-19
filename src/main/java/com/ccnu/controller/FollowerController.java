package com.ccnu.controller;

import com.ccnu.entity.Follower;
import com.ccnu.entity.User;
import com.ccnu.service.FollowerService;
import com.ccnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/follower")
public class FollowerController {
    @Autowired
    private FollowerService followerservice;
    @Autowired
    private UserService userservice;
    //@RequestMapping(value = "/f",method = {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/f1")
    public String toFollower(){
        return "friend.html";
    }
    //@PostMapping("/f")
    @RequestMapping(value = "/f",method = {RequestMethod.GET,RequestMethod.POST})
    public String allfollowers(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User login= (User) session.getAttribute("user");
        //System.out.println(login.getAccount());
        List<Follower> list=followerservice.searchfollower(login);
        String s="";
        int i=1;
        s+="<ul>";
        for(Follower follower:list){
            s+="<li style='border-bottom: 1px dashed;font-family: fangsong;font-size: 16px;margin-top: 14px;'>";
            s+=i;
            s+=": ";
            s+=follower.tostring();
            s+="<br>";
            i+=1;
            s+="</li>";
        }
        s+="</ul>";
        model.addAttribute("message",s);
        return "follower.html";
    }
//    @PostMapping("/f")
//    //@RequestMapping(value = "/f",method = {RequestMethod.GET,RequestMethod.POST})
//    public String allfollowers(Model model, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        User login= (User) session.getAttribute("user");
//        //System.out.println(login.getAccount());
//        List<Follower> list=followerservice.searchfollower(login);
//        String s="";
//        int i=1;
//        for(Follower follower:list){
//            s+=i;
//            s+=": ";
//            s+=follower.tostring();
//            s+="<br>";
//            i+=1;
//        }
//        model.addAttribute("message",list);
//        return "follower.html";
//    }

    @PostMapping("/f2")
    public String addfollowers(HttpServletRequest request,String account2){
        HttpSession session=request.getSession();
        User login= (User) session.getAttribute("user");
        String account1=login.getAccount();
        int i=followerservice.addfollower(account1,account2);
        if(i!=0){
            return "redirect:/follower/f";
        }
        return "redirect:/follower/f";
    }
    @PostMapping("f3")
    public String delfollowers( String account2, HttpServletRequest request){
        HttpSession session = request.getSession();
        User login= (User) session.getAttribute("user");
        String account1=login.getAccount();
        int i=followerservice.delfollower(account1,account2);
        if(i!=0){
            return "redirect:/follower/f";
        }
        return "redirect:/follower/f";
    }

    @RequestMapping(value = "f4",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String add(String account2,HttpServletRequest request){
        HttpSession session= request.getSession();
        User login= (User) session.getAttribute("user");
        String account1= login.getAccount();
        User followers=userservice.searchfollower(account2);
        List<Follower> list = followerservice.searchfollower(login);
        if(followers!=null) {
            Follower m=followerservice.is(account1,account2);
            if(m==null){
                int i = followerservice.addfollower(account1, account2);
                //System.out.println(account2);
                String s = "";
                s="<tr><td>"+account2;
                return s;
            }else{
                return "had";
            }
        }
        return "false";

    }
}
