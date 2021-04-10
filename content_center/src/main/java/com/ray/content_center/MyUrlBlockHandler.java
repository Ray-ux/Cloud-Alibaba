package com.ray.content_center;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyUrlBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {

        ErrorMsg msg = null;
        if (e instanceof FlowException) {
            msg = ErrorMsg.builder()
                    .status(101)
                    .message("降级了")
                    .build();
        } else if (e instanceof DegradeException) {

            msg = ErrorMsg.builder()
                    .status(102)
                    .message("热点数据异常")
                    .build();
        } else if (e instanceof ParamFlowException) {
            msg = ErrorMsg.builder()
                    .status(103)
                    .message("参数异常")
                    .build();

        } else if (e instanceof SystemBlockException) {
            msg = ErrorMsg.builder()
                    .status(104)
                    .message("系统异常")
                    .build();

        } else if (e instanceof AuthorityException) {
            msg = ErrorMsg.builder()
                    .status(105)
                    .message("权限异常")
                    .build();

        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");

        new ObjectMapper()
                .writeValue(httpServletResponse.getWriter(), msg);
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class ErrorMsg {

    private Integer status;
    private String message;


}
