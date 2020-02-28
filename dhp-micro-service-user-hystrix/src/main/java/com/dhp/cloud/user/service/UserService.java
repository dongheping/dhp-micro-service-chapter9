package com.dhp.cloud.user.service;

import java.util.List;

import com.dhp.cloud.user.model.User;

/**
 * @ClassName UserService
 * @Description 用户服务类
 * @Author DongHP
 * @Date 2020-02-02
 */
public interface UserService {

    /**
     * 根据ID获取用户信息
     * @param id  用户id
     * @return  对应的用户
     */
    User getById(Long id);

    /**
     * 获取所有用户信息
     * @return  获取所有用户信息
     */
    List<User> getUserList();
}
