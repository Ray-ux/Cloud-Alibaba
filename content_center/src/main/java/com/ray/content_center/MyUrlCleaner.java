package com.ray.content_center;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String s) {
//        让/share/1和/share/2的返回值相同
//        返回/share/{number}

//        1.获取已/为分隔符：获得["share","1"]数组
        String[] split = s.split("/");
//        2.JDK8语法
      return   Arrays.stream(split)
                .map(string -> {
//                    3.如果元素是数字则返回{number}
                    if (NumberUtils.isNumber(string)) {
                        return "{number}";
                    }
//                    4.不是数字就返回share
                    return string;
                })
//              重新构造share/{number}
                .reduce((a, b) -> a + "/" + b)
//              如果数组为空则返回空字符串
                .orElse("");
    }

}
