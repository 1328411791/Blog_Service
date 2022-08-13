package com.lihanyu;

import com.lihanyu.dao.UserDao;
import com.lihanyu.domain.User;
import com.lihanyu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogBackendApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void Useradd() {
        User user = new User(null, "123456", "123456", "123456");
        userService.register(user);
    }

    @Test
    public void userGetPage() {
        System.out.println(userService.getUserPage());
    }


}
