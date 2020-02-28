package com.dhp.cloud.consumer.service.fallback;

import java.util.List;

import com.dhp.cloud.consumer.model.Product;
import com.dhp.cloud.consumer.service.ProductFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProductFeignServiceFallbackFactory
 * @Description 调用producer的服务降级构造工厂
 * @Author DongHP
 * @Date 2020-01-29
 */
@Component
public class ProductFeignServiceFallbackFactory implements FallbackFactory<ProductFeignService> {

    @Override
    public ProductFeignService create(Throwable throwable) {
        return new ProductFeignService() {
            @Override
            public Product getById(long id) {
                Product product = new Product();
                product.setId(-1L);
                product.setName("无该商品");
                product.setDescription("调用商品服务失败,这是一个降级方法");
                return  product;
            }

            @Override
            public List<Product> getProductList() {
                return null;
            }
        };
    }
}
