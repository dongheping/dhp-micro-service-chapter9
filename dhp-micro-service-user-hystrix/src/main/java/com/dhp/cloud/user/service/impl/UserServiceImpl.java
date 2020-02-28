package com.dhp.cloud.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhp.cloud.user.model.User;
import com.dhp.cloud.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户服务实现类
 * @Author DongHP
 * @Date 2020-02-02
 */
@Service
public class UserServiceImpl implements UserService {

    private static Map<Long,User> userMap;

    static {
        userMap = new HashMap<>(20);
        addUsers();
    }
    private static void addUsers() {
        String[] names = {"张三","李四","王五","赵二麻子"};
        for (int i = 0; i < names.length; i++) {
            User user = User.builder().id(i+1).name(names[i]).sex("m").address("北京").build();
            userMap.put(user.getId(),user);
        }
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        userMap.forEach((key, value) -> list.add(value));
        return list;
    }
}
