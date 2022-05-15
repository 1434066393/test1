<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29 0029
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="color: red" >${img}</div>
    <form action="/day15/user?method=login" method="post">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
