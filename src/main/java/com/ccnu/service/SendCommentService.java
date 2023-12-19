package com.ccnu.service;

import com.ccnu.entity.Comment;

import java.util.List;

public interface SendCommentService {
    int send(String title,String content,String account);

    List<Comment> allcomment(String title);
}
