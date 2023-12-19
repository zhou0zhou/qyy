package com.ccnu.dao;

import java.util.List;
import com.ccnu.entity.User;

public interface ManageUserDao {

    List<User> findAll();
    void save(User user);

    void delete(String account);

    User find(String account);


    void update(User user);

    void update2(User user);
}
