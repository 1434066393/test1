
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29 0029
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/day15/js/jquery-1.12.4.js">

    </script>
    <style>
        div{
            width: 120px;
            height: 30px;
            border: 1px solid;
            border-radius: 15px;
            text-align: center;
            background-color: cadetblue;
            line-height: 30px;
            /*绝对定位*/
            position: absolute;
            left: 370px;
        }
    </style>
</head>
<body>
    <table width="1200px" border="1px" cellspacing="0px" align="center">
        <tr>
            <th>
                <input type="checkbox" name="all" onclick="fun1(checked)">全选/全不选
            </th>
            <th>学号</th>
            <th>姓名</th>
            <th>头像</th>
            <th>性别</th>
            <th>生日</th>
            <th>爱好</th>
            <th>操作</th>
        </tr>

        <c:if test="${pb.list!=null}">
        <c:forEach items="${pb.list}" var="stu">
            <tr>
            <td>
             <input type="checkbox" name="checkbox" value="${stu.sid}">
            </td>
            <td>${stu.sid}</td>
            <td>${stu.name}</td>
            <td align="center">
                <img src="http://localhost:8080/img/${stu.photo}" width="100px" height="100px">
            </td>
            <td>${stu.sex}</td>
            <td>${stu.birthday}</td>
            <td>${stu.hobby}</td>
            <td>
                <a href="/day15/stu?method=findStu&sid=${stu.sid}">修改</a>
            </td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
<p align="center">
    <a href="/day15/stu?method=findPages&currentPage=1&pageSize=3${param.name}$sex=${param.sex}">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="%{pb.currentPage==1}">
        <a href="#">上一页</a>
    </c:if>
    <c:if test="${pb.currentPage!=1}">
        <a href="/day15/stu?method=findPages&currentPage=${pb.currentPage-1}&pageSize=3&name=${param.name}&sex=${param.sex}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <a href="/day15/stu?method=findPages&currentPage=${pb.currentPage+1}&pageSize=3&name=${param.name}&sex={param.sex}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="${pb.currentPage==pb.totalPage}">
        <a href="#">下一页</a>
    </c:if>

    <c:if test="${pb.currentPage!=pb.totalPage}">
        <a href="/day15/stu?method=findPages&currentPage=${pb.totalPage}&pageSize=3name=${param.name}$sex=${param.sex}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    当前页${pb.currentPage}&nbsp;&nbsp;&nbsp;总条数${pb.totalCount}&nbsp;&nbsp;&nbsp;&nbsp;
    每页显示${pb.pageSize}条&nbsp;&nbsp;&nbsp;&nbsp;共${pb.totalPage}页
</p>
<p>
    <div onclick="del()">批量删除</div>
</p>
</body>
<script>
    function fun1(flag){
        //获取除全选框外其他的复选框
        $("input[name='checkbox']").prop("checked",flag)
    }
    //批量删除
    function del(){
        //1.获取当前页面中除全选框外被选中的复选框
        var inputs= $("input[name='checkbox']:checked")

        //2.遍历被选中的复选框
        //3.组装sids
        var sids =""
        $.each(inputs,function (index,input){
            if(index==inputs.length-1){
                sids+=input.value
            }else{
                sids+=input.value+","
            }
        })
        //4.发生请求 js页面重定向
        location.href="/day15/stu?method=del&sids="+sids
    }
</script>
</html>
