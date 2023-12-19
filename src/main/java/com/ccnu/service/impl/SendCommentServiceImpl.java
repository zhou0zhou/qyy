package com.ccnu.service.impl;

import com.ccnu.dao.SendCommentDao;
import com.ccnu.entity.Comment;
import com.ccnu.service.SendCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class SendCommentServiceImpl implements SendCommentService{
    @Autowired
    public SendCommentDao sendcommentdao;
    @Override
    public int send(String title,String content,String account){
        return sendcommentdao.send(title,content,account);
    }

    @Override
    public List<Comment> allcomment(String title){
        return sendcommentdao.allcomment(title);
    }
}
