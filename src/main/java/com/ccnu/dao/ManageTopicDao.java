package com.ccnu.dao;

import com.ccnu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ccnu.entity.Topic;

import java.util.List;

@Mapper
public interface ManageTopicDao {

    List<Topic> findAll();

    void save(Topic topic);

    void delete(String topic_title);

    Topic find(String topic_title);

    void update(Topic topic);
}
