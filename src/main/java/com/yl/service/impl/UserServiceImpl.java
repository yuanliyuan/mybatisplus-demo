package com.yl.service.impl;

import com.yl.mapper.UserMapper;
import com.yl.model.User;
import com.yl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> findUserList(){
        return userMapper.selectList(null);

    }

}
