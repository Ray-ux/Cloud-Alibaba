package com.ray.content_center;

import com.ray.content_center.domain.entity.Share;
import com.ray.content_center.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张烈文
 */
@RestController
public class TestController {

    @Autowired
    private ShareService shareService;


    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/test2")
    public List<ServiceInstance> test2() {
//        查询指定服务的所有实例信息
        List<String> services = discoveryClient.getServices();
        System.out.println(services.get(0));

        return discoveryClient.getInstances("user-center");
    }
}
