package com.dhp.cloud.user.controller;

import java.util.List;

import com.dhp.cloud.user.model.User;
import com.dhp.cloud.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Author DongHP
 * @Date 2020-02-02
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod="getFallback")
    public User getById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        if(user == null){
            throw new RuntimeException("没有该用户信息！");
        }
        return user;
    }

    public User getFallback(@PathVariable("id") Long id) {
        return User.builder().id(0L).name("无该用户").build();
    }

    @GetMapping("list")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
