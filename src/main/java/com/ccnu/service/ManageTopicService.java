package com.ccnu.service;

import com.ccnu.entity.Topic;

import java.util.List;

public interface ManageTopicService {

    List<Topic> findAll();
    void save(Topic topic);

    void delete(String topic_title);

    Topic find(String topic_title);

    void update(Topic topic);
}
