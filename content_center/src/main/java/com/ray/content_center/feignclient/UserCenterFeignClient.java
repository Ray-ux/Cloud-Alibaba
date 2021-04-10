package com.ray.content_center.feignclient;

import com.ray.content_center.configuration.UserCenterFeignConfiguration;
import com.ray.content_center.domain.dto.UserDTO;
import com.ray.content_center.feignclient.fallback.FallBackFactory;
import com.ray.content_center.feignclient.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 张烈文
 */
//@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    /**
     * http://user-center/users/{id}
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);
}
