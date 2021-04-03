package com.ray.user_center.service.user.impl;

import com.ray.user_center.dao.user.UserMapper;
import com.ray.user_center.domain.entity.User;
import com.ray.user_center.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

}
