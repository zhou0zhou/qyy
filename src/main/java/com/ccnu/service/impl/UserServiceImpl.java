package com.ccnu.service.impl;

import com.ccnu.entity.User;
import com.ccnu.service.UserService;
import com.ccnu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String account,String password) {
        return userDao.login(account, password);
    }

    public User forgetpassword(String account,String security_answer){return userDao.forgetpassword(account, security_answer);}
    @Override
    public void updatePassword(User user) {userDao.updatePassword(user);}
    @Override
    public User personalcenter(String account){return userDao.personalcenter(account);}
    @Override
    public void modifyinformation(User user){userDao.modifyinformation(user);};

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User find(String account) {
        return userDao.find(account);
    }

    @Override
    public void update(User user) {userDao.update(user);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User feedback(String account) {return userDao.feedback(account);}

    @Override
    public void update2(User user) {
        userDao.update2(user);
    }

    @Override
    public User searchfollower(String account2){
        return userDao.searchfollower(account2);
    }
}
