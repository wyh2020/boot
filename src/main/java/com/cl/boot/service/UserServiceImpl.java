package com.cl.boot.service;

import com.cl.boot.api.UserService;
import com.cl.boot.mapper.UserMapper;
import com.cl.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 * Created by MrC on 2017/6/20
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello() {
        return "Hello GO Lang";
    }

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    @Transactional
    public void editUsers() throws RuntimeException {
        User user1 = userMapper.selectByPrimaryKey(1);
        User user2 = userMapper.selectByPrimaryKey(2);
        user1.setSex(2);
        user2.setSex(3);
        userMapper.updateByPrimaryKey(user1);
        userMapper.updateByPrimaryKey(user2);
    }
}
