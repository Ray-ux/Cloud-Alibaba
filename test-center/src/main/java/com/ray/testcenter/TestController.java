package com.ray.testcenter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张烈文
 */
@RestController
public class TestController {


    @GetMapping("/test")
    public String test() {
        System.out.println("被请求了");
        return "hello world";
    }


}
