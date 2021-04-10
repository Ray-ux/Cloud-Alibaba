package com.ray.content_center.feignclient.fallback;

import com.ray.content_center.domain.dto.UserDTO;
import com.ray.content_center.feignclient.UserCenterFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FallBackFactory implements FallbackFactory<UserCenterFeignClient> {
    @Override
    public UserCenterFeignClient create(Throwable throwable) {

        return new UserCenterFeignClient() {
            @Override
            public UserDTO findById(Integer id) {

                log.warn("远程调用被限流、降级了", throwable);

                UserDTO userDTO = new UserDTO();
                userDTO.setWxNickname("默认用户");
                return userDTO;
            }
        };
    }
}
