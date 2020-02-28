package com.dhp.cloud.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description 用户实体
 * @Author DongHP
 * @Date 2020-02-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String sex;
    private String address;
    private String telphone;
}
