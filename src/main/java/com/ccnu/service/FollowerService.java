package com.ccnu.service;

import com.ccnu.entity.Follower;
import com.ccnu.entity.User;

import java.util.List;

public interface FollowerService {
    List<Follower> searchfollower(User user);

    int addfollower(String account1,String account2);

    int delfollower(String account1,String account2);

    Follower is(String account1,String account2);
}
