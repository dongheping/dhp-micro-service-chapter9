package com.dhp.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @ClassName UserHystrixApplication
 * @Description 用户启动类
 * @Author DongHP
 * @Date 2020-2-2
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class UserHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserHystrixApplication.class, args);
    }

}
