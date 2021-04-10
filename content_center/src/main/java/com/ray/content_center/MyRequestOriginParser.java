package com.ray.content_center;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


//@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
//        从请求参数中获取名为origin的参数并返回
//        如果获取不到origin参数，那么就抛异常
        String origin = httpServletRequest.getParameter("origin");
        if (StringUtils.isEmpty(origin)) {
            throw new IllegalArgumentException("origin must be specified");
        }

        return origin;
    }
}
