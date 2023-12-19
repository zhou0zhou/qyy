package com.ccnu.service.impl;

import com.ccnu.dao.SendTopicDao;
import com.ccnu.entity.Topic;
import com.ccnu.entity.User;
import com.ccnu.service.SendTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendTopicServiceImpl implements SendTopicService {
    @Autowired
    public SendTopicDao sendtopicdao;
    @Override
    public int publish(String title,String content,String account,String name){
        return sendtopicdao.publish(title,content,account,name);
    }
    @Override
    public List<Topic> findmyAll(User user){
        return sendtopicdao.findmyAll(user);
    }

    @Override
    public void likes(String title,Integer likes){
        sendtopicdao.likes(title,likes);
    }
}
