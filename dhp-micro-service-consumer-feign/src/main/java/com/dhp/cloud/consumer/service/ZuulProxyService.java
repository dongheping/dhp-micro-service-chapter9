package com.dhp.cloud.consumer.service;

import java.util.List;

import com.dhp.cloud.consumer.config.FeignClientConfig;
import com.dhp.cloud.consumer.model.Product;
import com.dhp.cloud.consumer.model.User;
import com.dhp.cloud.consumer.service.fallback.ZuulProxyServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ZuulProxyService
 * @Description feign访问zuul的代理服务
 * @Author DongHP
 * @Date 2020-02-10
 */
@FeignClient(name = "DHP-MICRO-SERVICE-ZUUL-GATEWAY", configuration = FeignClientConfig.class,
    fallbackFactory = ZuulProxyServiceFallbackFactory.class)
public interface ZuulProxyService {

    @RequestMapping("/producer-proxy/product/get/{id}")
    Product getProductById(@PathVariable("id") long id);

    @RequestMapping("/producer-proxy/product/list")
    List<Product> getProductList();

    @RequestMapping("/user-proxy/product/get/{id}")
    User getUserById(@PathVariable("id") long id);

    @RequestMapping("/user-proxy/user/list")
    List<User> getUserList();
}
