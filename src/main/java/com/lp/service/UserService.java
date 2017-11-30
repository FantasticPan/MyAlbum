package com.lp.service;

import com.lp.dao.UserDao;
import com.lp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 李攀 on 2017/11/24.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
