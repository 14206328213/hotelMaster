<%--
  Created by IntelliJ IDEA.
  User: FHX
  Date: 2019/1/6
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/userInfo.js"></script>
</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">HotelMaster</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="order.html">主页</a>
                </li>
                <li  class="active"><a href="#">关于我</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- 表格 -->
<div>
    <table class="table table-bordered table-width">
        <caption>个人信息</caption>
        <tr>
            <td>用户名</td>
            <td>${sessionScope.customer.cname}</td>
        </tr>
        <tr>
            <td>电话号码</td>
            <td>${sessionScope.customer.tel}</td>
        </tr>
        <tr>
            <td>身份证</td>
            <td>${sessionScope.customer.cID}</td>
        </tr>
        <tr>
            <td>身份</td>
            <td>普通用户</td>
        </tr>
        <tr>
            <td><button onclick="changepwd()">修改密码</button></td>
            <td><button>修改个人信息</button></td>
        </tr>
    </table>
</div>

<!-- 底部内容 -->
<!-- <div class="jumbotron text-center" style="margin-bottom:0">
  <p>版权所有</p>
</div> -->
</body>
</html>