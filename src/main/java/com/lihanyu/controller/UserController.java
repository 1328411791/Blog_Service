package com.lihanyu.controller;

import com.lihanyu.Utiliy.TokenCreate;
import com.lihanyu.domain.Result;
import com.lihanyu.domain.User;
import com.lihanyu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController()
@RequestMapping("/users")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ResponseBody
    public Result login(@ApiParam("用户名") @RequestParam String userName
            , @ApiParam("密码") @RequestParam String password, HttpServletResponse response) {

        if (userService.login(userName, password)) {
            Cookie cookie = new Cookie("session", TokenCreate.tokenCreate(userName));
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
            return new Result(200, "Success", null);
        } else {
            return new Result(400, "用户名或密码错误", null);
        }

    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    @ResponseBody
    public Result register(@ApiParam("User对象") @RequestParam User user) {
        userService.register(user);
        return new Result(Code.SUCCESS, "注册成功", null);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return new Result(Code.SUCCESS, "查询成功", user);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
