package com.ccnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId; // 添加用户ID字段
    private String account;
    private String password;
    private String sex;
    private String nickname;
    private String picture;
    private String address;
    private String introduction;
    private String security_answer;
    private String suggestion;
}
