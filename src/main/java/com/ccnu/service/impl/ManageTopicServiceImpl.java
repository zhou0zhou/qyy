package com.ccnu.service.impl;

import com.ccnu.entity.Topic;
import com.ccnu.service.ManageTopicService;
import com.ccnu.dao.ManageTopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManageTopicServiceImpl implements ManageTopicService {
    @Autowired
    private ManageTopicDao manageTopicDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)  //支持事务，事务是传播的
    public List<Topic> findAll() {
        return manageTopicDao.findAll();
    }
    @Override
    public void save(Topic topic) {
        manageTopicDao.save(topic);
    }

    @Override
    public void delete(String topic_title) {
        manageTopicDao.delete(topic_title);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Topic find(String topic_title) {
        return manageTopicDao.find(topic_title);
    }

    @Override
    public void update(Topic topic) {
        manageTopicDao.update(topic);
    }
}
