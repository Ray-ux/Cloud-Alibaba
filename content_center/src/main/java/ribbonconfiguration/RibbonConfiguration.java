package ribbonconfiguration;


import com.netflix.loadbalancer.IRule;
import com.ray.content_center.configuration.NacosSameClusterWeightedRule;
import com.ray.content_center.configuration.NacosWeightedRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张烈文
 */
@Configuration
public class RibbonConfiguration {


    @Bean
    public IRule ribbonRule() {

        return new NacosSameClusterWeightedRule();
    }
}
