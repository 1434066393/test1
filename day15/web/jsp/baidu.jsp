<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/6 0006
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        #box{
            display: inline-block;
        }
        #search{
            width: 545px;
            height: 42px;
            border-color: #4E6EF2;
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
            float: left;
        }
        #btn{
            width: 108px;
            height: 42px;
            background-color: #4E6EF2;
            color: #fff;
            border: none;
            font-size: 17px;
            font-weight: 400;
            border-top-right-radius: 10px;
            border-bottom-right-radius: 10px;
            float: left;
        }
        #show{
            width: 545px;
            border: 1px solid #4E6EF2;
            position: relative;
            left: -55px;
            text-align: left;
        }
    </style>
    <script src="/day17/js/jquery-1.12.4.js"></script>
</head>
<body>
<certer>
    <img alt="" width="310px" height="150px" src="${pageContext.request.contextPath}/img/google.png"><br>
    <div id="box">
        <input id="search" type="text" name="search" onblur="fun2(this.value)">
        <button id="btn">百度一下</button>

    </div>
    <div id="show"></div>
</certer>
</body>
<script>
    function fun2(value){
        //发送ajax
        $.ajax({
            url:"/day17/google",
            data:{"name":value},
            type:"get",
            success:function (list){
                //遍历JSON获取内容
                //将内容添加到id为show的div中
                $("#show").html("")
                $.each(list,function (index,user){
                    $("#show").append(user.name+ "<br>")
                })
            },
            dataType:"json"
        })
    }
</script>
</html>
