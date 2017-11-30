package com.lp.dao;

import com.lp.model.User;

/**
 * Created by 李攀 on 2017/11/24.
 */
public interface UserDao {

    User getUserByUsername(String username);

    void addUser(User user);
}
