package com.ray.content_center.feignclient.fallback;

import com.ray.content_center.domain.dto.UserDTO;
import com.ray.content_center.feignclient.UserCenterFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserCenterFeignClient {
    @Override
    public UserDTO findById(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setWxNickname("默认用户");

        return userDTO;
    }
}
