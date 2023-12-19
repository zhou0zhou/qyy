package com.ccnu.service;

import com.ccnu.entity.Topic;
import com.ccnu.entity.User;

import java.util.List;

public interface SendTopicService {
    int publish(String title,String content,String account,String name);

    List<Topic> findmyAll(User user);
    void likes(String title,Integer likes);
}
