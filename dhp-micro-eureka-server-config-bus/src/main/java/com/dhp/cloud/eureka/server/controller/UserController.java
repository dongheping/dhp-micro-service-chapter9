package com.dhp.cloud.eureka.server.controller;

import com.dhp.cloud.eureka.server.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description 用于演示自动刷新的控制器
 * @Author DongHP
 * @Date 2020-02-29
 */
@RestController
public class UserController {
    @Autowired
    private UserConfig userConfig;

    @GetMapping("userConfig")
    public Object userConfig(){
        return userConfig.toString();
    }
}
