package com.bkunzhang.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @author bkunzhang
 * @date 2019/9/28
 */
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LogFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        MDC.put("traceId", "traceId=" + UUID.randomUUID().toString());
        log.info("LogFilter doFilter url={}", request.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.remove("traceId");
    }

    @Override
    public void destroy() {
        log.info("LogFilter destroy");

    }
}
