package com.dhp.cloud.producer.controller;

import java.util.List;

import com.dhp.cloud.producer.model.Product;
import com.dhp.cloud.producer.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProducerController
 * @Description 生产者控制器
 * @Author DongHP
 * @Date 2019-12-22
 */
@RestController
@RequestMapping("product")
public class ProducerController {

    @Autowired
    private ProductService productService;

    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Product getById(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        if (product == null) {
            throw new RuntimeException("该产品已下架！");
        }
        return product;
    }

    public Product getFallback(@PathVariable("id") Long id) {
        Product product = new Product();
        product.setName("无");
        product.setDescription("没有该商品信息!");
        product.setId(0L);
        return product;
    }

    @GetMapping("list")
    public List<Product> getProductList() {
        return productService.getProductList();
    }

    @RequestMapping(value = "/add")
    public Object add(@RequestBody Product product) {
        return productService.add(product);
    }

}
