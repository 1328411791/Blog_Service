package com.lihanyu.service;

import com.lihanyu.domain.User;

import java.util.List;

public interface UserService {

    public boolean register(User user);

    public User login(String username, String password);

    public User getUserById(Integer id);

    public List<User> getUserPage();

}
