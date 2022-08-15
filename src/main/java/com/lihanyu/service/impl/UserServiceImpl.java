package com.lihanyu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lihanyu.dao.UserDao;
import com.lihanyu.domain.User;
import com.lihanyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean register(User user) {
        if (userDao.getUserByUsername(user.getUsername()) != null) {
            try {
                userDao.insert(user);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.loginUser(username, password) != null;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getUserPage(int current, int size) {
        IPage<User> page = new Page<>(1, 2);
        userDao.selectPage(page, null);
        return page.getRecords();
    }
}
