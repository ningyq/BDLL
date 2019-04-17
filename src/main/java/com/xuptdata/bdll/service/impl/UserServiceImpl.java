package com.xuptdata.bdll.service.impl;

import com.xuptdata.bdll.entity.User;
import com.xuptdata.bdll.mapper.UserMapper;
import com.xuptdata.bdll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
