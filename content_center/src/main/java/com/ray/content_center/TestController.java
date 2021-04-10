package com.ray.content_center;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ray.content_center.domain.dto.UserDTO;
import com.ray.content_center.domain.entity.Share;
import com.ray.content_center.feignclient.TestBaiduFeignClient;
import com.ray.content_center.feignclient.TestUserCenterFeignClient;
import com.ray.content_center.service.content.ShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author 张烈文
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private ShareService shareService;


    @Autowired
    private TestUserCenterFeignClient testUserCenterFeignClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestBaiduFeignClient testBaiduFeignClient;
    @GetMapping("/test2")
    public List<ServiceInstance> test2() {
//        查询指定服务的所有实例信息
        Queue queue = new LinkedList();
        queue.size();
        List<String> services = discoveryClient.getServices();
        System.out.println(services.get(0));
        Stack stack = new Stack();
        HashMap map = new HashMap();

        return discoveryClient.getInstances("user-center");
    }

    @GetMapping("/test1")
    public UserDTO test1(UserDTO userDTO) {
        return testUserCenterFeignClient.query(userDTO);
    }

    @GetMapping("/test3")
    public String test3() {
        return testBaiduFeignClient.index();
    }


    /**
     * 直接使用API方式
     * @param a
     * @return
     */
    @GetMapping("/test-sentinel-api")
    public String testSentinelAPI(@RequestParam(required = false) String a)  {
        String resourceName = "test-sentinel-api";
        ContextUtil.enter(resourceName, "test-wfw");
//        定义一个sentinel保护的资源，名称是test-sentinel-api
        Entry entry = null;
        try {
            entry = SphU.entry(resourceName);
//            被保护的业务逻辑
            if (StringUtils.isEmpty(a)) {
                throw new IllegalArgumentException("a不能为空");
            }
            return a;
//            如果被保护的资源被限流或者降级了，就会抛出BlockException
        } catch (BlockException e) {
            log.warn("限流或者降级了", e);
            return "限流，或者降级了";
        } catch (IllegalArgumentException e1) {
            Tracer.trace(e1);
            return "参数非法";
        } finally {
            if (entry != null) {
//                退出entry
                entry.exit();


            }

            ContextUtil.exit();
        }

    }

    /**
     * 注解方式
     *
     * @param a
     * @return
     */

    @GetMapping("/test-sentinel-resource")
    @SentinelResource(value = "test-sentinel-resource",blockHandler = "block",fallback = "fallback" )
    public String testSentinelResource(@RequestParam(required = false) String a) {
//            被保护的业务逻辑
        if (StringUtils.isEmpty(a)) {
            throw new IllegalArgumentException("a cannot be blank");
        }
        return a;

    }

    /**
     * 处理限流或者降级
     * @param a
     * @param e
     * @return
     */
    public String block(String a,BlockException e) {
        log.warn("限流或者降级了", e);
        return "限流，或降级了 block";
 }

    /**
     * 1.5及以下 处理降级
     * 1.6以上处理Throwable
     * @param a
     * @return
     */
    public String fallback(String a) {
        return "限流，或者降级了 fallback";
    }


}
