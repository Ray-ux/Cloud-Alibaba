package com.ray.content_center.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;



/**
 * @author 张烈文
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
