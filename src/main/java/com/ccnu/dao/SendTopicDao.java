package com.ccnu.dao;

import com.ccnu.entity.Topic;
import com.ccnu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SendTopicDao {
    int publish(@Param("title") String title, @Param("content") String content, String account, @Param("name") String name);

    List<Topic> findmyAll(User user);

    void likes(String title,Integer likes);
}