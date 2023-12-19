package com.ccnu.dao;

import com.ccnu.entity.Follower;
import com.ccnu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FollowerDao {
    List<Follower> searchfollower(User user);

    int addfollower(String account1,@Param("account2") String account2);

    int delfollower(String account1,@Param("account2") String account2);

    Follower is(String account1,@Param("account2") String account2);
}
