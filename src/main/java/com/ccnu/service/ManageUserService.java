package com.ccnu.service;

import com.ccnu.entity.User;

import java.util.List;

public interface ManageUserService {
    List<User> findAll();
    void save(User user);
    void delete(String account);

    User find(String account);

    void update(User user);

    void update2(User user);
}
