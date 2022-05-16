<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28 0028
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
      文件上传3个必要条件
         1、表单提交方式必须是post
         2、表单的编码方式必须是mutipart/form-data
         3、所提交的servlet上必须添加注解@MutipartConfig
--%>
<form action="/day15/stu?method=add" method="post" enctype="multipart/form-data">
    <table width="400px" cellspacing="0px";>
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>

        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>

        <tr>
            <td>爱好:</td>
            <td>
                <input type="checkbox" name="hobby" value="魑">魑
                <input type="checkbox" name="hobby" value="魅">魅
                <input type="checkbox" name="hobby" value="魍">魍
                <input type="checkbox" name="hobby" value="魉">魉
            </td>
        </tr>

        <tr>
            <td>出生日期:</td>
            <td>
                <input type="date" name="birthday">
            </td>
        </tr>
        <tr>
            <td>个人简介:</td>
            <td>
                <textarea rows="3" cols="12" name="sdesc"></textarea>
            </td>
        </tr>

        <tr>
            <td>头像:</td>
            <td>
                <input type="file" name="photo">
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
