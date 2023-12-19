package com.ccnu.service.impl;

import com.ccnu.dao.ManageUserDao;
import com.ccnu.entity.User;
import com.ccnu.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    @Autowired
    private ManageUserDao manageUserDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)  //支持事务，事务是传播的
    public List<User> findAll() {
        return manageUserDao.findAll();
    }
    @Override
    public void save(User user) {
        manageUserDao.save(user);
    }

    @Override
    public void delete(String account) {
        manageUserDao.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User find(String account) {
        return manageUserDao.find(account);
    }


    @Override
    public void update(User user) {
        manageUserDao.update(user);
    }

    @Override
    public void update2(User user) {
        manageUserDao.update(user);
    }
}
