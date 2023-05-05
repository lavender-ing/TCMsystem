package com.example.indexmanager.service;

import com.example.indexmanager.pojo.User;

import java.util.Date;

public interface UserService {

    /*根据用户名查找用户*/
    public User selectByUsername(String username);

    /*插入新用户*/
    public int insert(User user);

    /*更新用户信息*/
    public int update(User user);

    public int updateLastLogin(String username, Date lastlogin);

    public String getQuestion(String username);

    public int updatePassword(User user);
}
