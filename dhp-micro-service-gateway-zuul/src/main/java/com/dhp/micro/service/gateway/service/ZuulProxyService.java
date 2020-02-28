package com.dhp.micro.service.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName ZuulProxyService
 * @Description feign访问zuul的代理服务
 * @Author DongHP
 * @Date 2020-02-10
 */
@FeignClient()
public interface ZuulProxyService {

}
