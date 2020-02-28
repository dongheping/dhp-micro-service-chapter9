package com.dhp.cloud.consumer.service.fallback;

import java.util.List;

import com.dhp.cloud.consumer.model.Product;
import com.dhp.cloud.consumer.model.User;
import com.dhp.cloud.consumer.service.ZuulProxyService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZuulProxyServiceFallbackFactory
 * @Description 服务降级工厂类
 * @Author DongHP
 * @Date 2020-02-10
 */
@Component
public class ZuulProxyServiceFallbackFactory implements FallbackFactory<ZuulProxyService> {

    @Override
    public ZuulProxyService create(Throwable throwable) {
        return new ZuulProxyService() {
            @Override
            public Product getProductById(long id) {
                return Product.builder().id(-1).name("无该商品信息").build();
            }
            @Override
            public List<Product> getProductList() {
                return null;
            }
            @Override
            public User getUserById(long id) {
                return User.builder().id(-1).name("无该用户信息").build();
            }
            @Override
            public List<User> getUserList() {
                return null;
            }
        };
    }
}
