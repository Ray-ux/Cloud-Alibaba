package com.ray.user_center;

import com.ray.user_center.domain.entity.User;
import com.ray.user_center.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

@SpringBootTest
class UserCenterApplicationTests {


    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User byId = userService.findById(1);
        System.out.println(byId);
    }





}
