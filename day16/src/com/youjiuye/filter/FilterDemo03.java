package com.youjiuye.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/*")
public class FilterDemo03 implements Filter {
    @Override
    /*
    *  init初始化方法，在服务器启动的时候执行，他的调用标志filter在内存中被创建，
    * 在整个生命周期过程中仅执行一次
    * */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter在内存中被创建了");
    }
    /*拦截方法，请求一次，执行一次*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter在拦截资源");
    }
    /*
    * 这个方法在服务器关闭的时候调用，标志着filter被消耗了，在整个filter生命周期过程中仅执行一次
    * */
    @Override
    public void destroy() {
        System.out.println("filter被消耗了");
    }
}
