package com.lihanyu.service;

import com.lihanyu.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface UserService {

    public boolean register(User user);

    public boolean login(String username, String password);

    public User getUserById(Integer id);

    public User getByUsername(String username);

    public List<User> getUserPage(int current, int size);

}
