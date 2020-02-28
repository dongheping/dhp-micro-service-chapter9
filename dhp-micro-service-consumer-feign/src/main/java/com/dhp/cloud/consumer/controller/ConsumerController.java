package com.dhp.cloud.consumer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhp.cloud.consumer.model.Product;
import com.dhp.cloud.consumer.model.User;
import com.dhp.cloud.consumer.service.ProductFeignService;
import com.dhp.cloud.consumer.service.ZuulProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConsumerController
 * @Description 消费者控制器
 * @Author DongHP
 * @Date 2019-12-22
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    //private static final String GET_PRODUCT_ID_URL = "http://localhost:7001/product/get/";
    //private static final String GET_PRODUCT_LIST_URL = "http://localhost:7001/product/list";
    //private static final String GET_PRODUCT_ID_URL = "http://DHP-MICRO-SERVICE-PRODUCER/product/get/";
    //private static final String GET_PRODUCT_LIST_URL = "http://DHP-MICRO-SERVICE-PRODUCER/product/list";

    //@Autowired
    //private RestTemplate restTemplate;
    //@Autowired
    //private HttpHeaders httpHeaders;

    //@GetMapping("get/product/{id}")
    //public Product getById(@PathVariable("id") Long id) {
    //    return restTemplate.getForObject(GET_PRODUCT_ID_URL + id,Product.class);
    //}
    //
    //@GetMapping("list/product")
    //public List<Product> getProductList() {
    //    return restTemplate.getForObject(GET_PRODUCT_LIST_URL,List.class);
    //}

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    private ZuulProxyService zuulProxyService;

    @GetMapping("get/product/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productFeignService.getById(id);
    }

    @GetMapping("get/zuul-product/{id}")
    public Product getProductByZuul(@PathVariable("id") Long id) {
        return zuulProxyService.getProductById(id);
    }

    @GetMapping("list/product")
    public List<Product> getProductList() {
        return productFeignService.getProductList();
    }

    @GetMapping("list/zuul-product")
    public List<Product> getZuulProxyProductList() {
        return zuulProxyService.getProductList();
    }

    @GetMapping("list/user-product")
    public Map<String,Object> getUserAndProductList(){
        Map<String,Object> map = new HashMap<>();
        List<Product> productList = zuulProxyService.getProductList();
        List<User> userList = zuulProxyService.getUserList();
        map.put("user",userList);
        map.put("product",productList);
        return map;
    }
}
