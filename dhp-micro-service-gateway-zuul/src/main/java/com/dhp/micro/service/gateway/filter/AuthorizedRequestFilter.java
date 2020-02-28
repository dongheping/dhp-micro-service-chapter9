package com.dhp.micro.service.gateway.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class AuthorizedRequestFilter extends ZuulFilter {

    @Override
    public String filterType() { return FilterConstants.PRE_TYPE;}

    @Override
    public int filterOrder() { return 0; }

    @Override
    public boolean shouldFilter() { return true; }

    @Override
    public Object run() throws ZuulException {
        // 1.获取当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext() ;
        // 2.构建认证信息
        String auth = "admin:admin";
        byte[] encodedAuth = Base64.getEncoder()
            .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
