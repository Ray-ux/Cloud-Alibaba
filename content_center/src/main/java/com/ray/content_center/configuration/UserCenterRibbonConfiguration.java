package com.ray.content_center.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 张烈文
 */
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@Configuration
public class UserCenterRibbonConfiguration {

}
