package com.lihanyu.controller;

import com.lihanyu.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
@Api(tags = "用户接口")
public class UserController {


    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ResponseBody
    public String login(@ApiParam("用户名") @RequestParam String userName
            , @ApiParam("密码") @RequestParam String password) {
        return userName + " " + password;
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    @ResponseBody
    public String register(@ApiParam("User对象") @RequestParam User user) {
        return user.toString();
    }

    @GetMapping("/{id}")
    public User selectById(@PathVariable Integer id) {
        return new User(1, "lihanyu", "123456", "123456");
    }
}
