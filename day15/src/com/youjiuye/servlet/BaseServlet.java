package com.youjiuye.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置post提交乱码解决
        req.setCharacterEncoding("utf-8");
        //获取要访问的业务方法名称
        String method = req.getParameter("method");
        //获取该类字节码文件
        Class<? extends BaseServlet> claz = this.getClass();
        try {
            //根据方法名和方法的参数类型去字节码文件中获取到该方法
            Method m = claz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            m.invoke(claz.newInstance(),req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
