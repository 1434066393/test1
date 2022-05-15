package com.youjiuye.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo04 implements Filter {
    /*filter xml 配置方式拦截多个具体的资源路径*/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我拦截了m1和m2");
    }

    @Override
    public void destroy() {

    }
}
