package com.ccnu.service;

import com.ccnu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    void register(User user);
    User login(String account,String password);

    User forgetpassword(String account,String security_answer);
    void updatePassword(User user);
    User personalcenter(String account);
    void modifyinformation(User user);

    User find(String account);

    void update(User user);
    User feedback(String account);

    void update2(User user);

    User searchfollower(String account2);
}
