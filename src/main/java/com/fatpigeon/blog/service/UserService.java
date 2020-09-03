package com.fatpigeon.blog.service;

import com.fatpigeon.blog.dao.UserDao;
import com.fatpigeon.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return User 用户
     */
    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }

}
