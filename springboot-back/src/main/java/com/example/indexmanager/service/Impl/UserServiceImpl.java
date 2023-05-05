package com.example.indexmanager.service.Impl;

import com.example.indexmanager.mapper.UserMapper;
import com.example.indexmanager.pojo.User;
import com.example.indexmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public int insert(User user) {
        /*先检查是否存在同名用户*/
        if(userMapper.checkExist(user.getUsername())>0){
            /*已存在同名用户*/
            return 0;
        }else {
            /*可以注册*/
            /*插入用户*/
            int res = userMapper.insert(user);
            return res>0?1:0;
        }
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int updateLastLogin(String username, Date lastlogin) {
        return userMapper.updateLastLogin(username,lastlogin);
    }

    @Override
    public String getQuestion(String username) {
        return userMapper.getQuestion(username);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }
}