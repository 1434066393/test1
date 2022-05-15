package com.youjiuye.filter;

import javax.servlet.*;
import java.io.IOException;
/*过滤器*/
public class FilterDemo01  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
/*拦截方法*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是拦路虎");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
