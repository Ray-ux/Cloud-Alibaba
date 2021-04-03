package com.ray.user_center.service.user;

import com.ray.user_center.domain.entity.User;

public interface UserService {
    User findById(Integer id);
}
