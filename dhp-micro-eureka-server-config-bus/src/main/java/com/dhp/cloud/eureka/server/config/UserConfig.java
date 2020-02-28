package com.dhp.cloud.eureka.server.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserConfig
 * @Description 用于演示自动刷新的配置
 * @Author DongHP
 * @Date 2020-02-29
 */
@Component
@RefreshScope
@Data
public class UserConfig {
    @Value("${user.config.name}")
    private String name;
    @Value("${user.config.password}")
    private String password;
    @Value("${user.config.description}")
    private String description;
}
