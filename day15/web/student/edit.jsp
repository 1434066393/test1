<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29 0029
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/day15/stu?method=update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="oldPhoto" value="${stu.photo}">
    <input type="hidden" name="sid" value="${stu.sid}">
    <table width="400px" cellspacing="0px">
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="name" value="${stu.name}">
            </td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>

                <input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男'}">checked</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td>
                <%--
                     参数1:域对象中的值
                     参数2:要包含的字符串
                     &lt;c:if test="${fn:contains(name, searchString)}">

                --%>

                <input type="checkbox" name="hobby" value="魑" <c:if test="${fn:contains(stu.hobby, '魑')}">checked</c:if>>魑
                <input type="checkbox" name="hobby" value="魅" <c:if test="${fn:contains(stu.hobby, '魅')}">checked</c:if>>魅
                <input type="checkbox" name="hobby" value="魍" <c:if test="${fn:contains(stu.hobby, '魍')}">checked</c:if>>魍
                <input type="checkbox" name="hobby" value="魉" <c:if test="${fn:contains(stu.hobby, '魉')}">checked</c:if>>魉
            </td>
        </tr>
        <tr>
            <td>出生日期:</td>
            <td>
                <input type="date" name="birthday" value="${stu.birthday}">
            </td>
        </tr>
        <tr>
            <td>个人简介:</td>
            <td>
                <textarea rows="3" cols="12" name="sdesc">${stu.sdesc}</textarea>
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
