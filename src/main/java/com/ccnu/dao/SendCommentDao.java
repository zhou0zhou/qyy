package com.ccnu.dao;

import com.ccnu.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SendCommentDao {
    int send(String title,@Param("content") String content,String account);

    List<Comment> allcomment(String title);
}
