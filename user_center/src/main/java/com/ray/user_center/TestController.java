package com.ray.user_center;

import com.ray.user_center.domain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张烈文
 */
@RestController
public class TestController {


    @GetMapping("/q")
    public User test(User user) {
        return user;
    }
}
