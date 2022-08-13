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
        try {
            userDao.insert(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getUserPage() {
        IPage<User> page = new Page<>(1, 2);
        userDao.selectPage(page, null);
        return page.getRecords();
    }
}
