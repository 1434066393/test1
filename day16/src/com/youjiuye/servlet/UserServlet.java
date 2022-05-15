package com.youjiuye.servlet;

import com.youjiuye.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends BaseServlet{
    UserService servicce = new  UserService();
    public void login(HttpServletRequest request, HttpServletResponse response){
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用业务
        //User user = servicce.login(username, password);
    }
}
