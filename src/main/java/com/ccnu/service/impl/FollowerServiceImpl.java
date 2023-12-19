package com.ccnu.service.impl;

import com.ccnu.dao.FollowerDao;
import com.ccnu.entity.Follower;
import com.ccnu.entity.User;
import com.ccnu.service.FollowerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerServiceImpl implements FollowerService {
    @Autowired
    public FollowerDao followerdao;
    @Override
    public List<Follower> searchfollower(User user){
        return followerdao.searchfollower(user);
    }
    @Override
    public int addfollower(String account1,String account2){
        return followerdao.addfollower(account1,account2);
    }
    @Override
    public int delfollower(String account1, String account2){
        return followerdao.delfollower(account1,account2);
    }

    @Override
    public Follower is(String account1,String account2){
        return followerdao.is(account1,account2);
    }
}
