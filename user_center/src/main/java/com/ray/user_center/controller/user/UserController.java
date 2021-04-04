package com.ray.user_center.controller.user;


import com.ray.user_center.domain.entity.User;
import com.ray.user_center.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.PriorityQueue;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        log.info("我被请求了");
        return userService.findById(id);
    }


}
