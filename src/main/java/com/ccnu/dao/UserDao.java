package com.ccnu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ccnu.entity.User;

import java.util.List;

public interface UserDao {


    void save(User user);

    //mybatis传多个参数需要进行参数绑定
    User login(@Param("account") String account, @Param("password") String password);

    User forgetpassword(@Param("account") String account, @Param("security_answer") String security_answer);

    void updatePassword(User user);
    User personalcenter(String account);
    void modifyinformation(User user);

    User find(String account);

    void update(User user);

    User feedback(String account);

    void update2(User user);

    User searchfollower(String account2);
}
