<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fhx.entity.Room" %>
<%@page import="com.fhx.util.Time" %>
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">HotelMaster</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="/show.html">主页</a>
                </li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login.html"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
        </ul>
    </div>
</nav>
<!-- 表格 -->
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#home" data-toggle="tab">
            房间<span class="badge pull-right">${freenum}</span>
        </a>
    </li>
    <li><a href="#freeroom" data-toggle="tab">空闲客房</a></li>
    <li><a href="#room" data-toggle="tab">今日价格</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <!-- 表格 -->
        <table class="table table-bordered table-width">
            <jsp:useBean id = "time" class ="com.fhx.util.Time"></jsp:useBean>
            <caption><span id="time">${time.nowTime}</span></caption>
            <thead>
            <tr>
                <th>名称</th>
                <th>价格</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.rooms}" var="room">
                <tr>
                    <td>${room.rname}</td>
                    <td>${room.rcost}</td>
                    <c:choose>
                        <c:when test="${room.status==Room.FREE}">
                            <td style="color:green"><a href="/orderCheck.do?rID=${room.rID}">空闲</a></td>
                        </c:when>
                        <c:when test="${room.status==Room.ORDER}">
                            <td style="color: #31b0d5">预约</td>
                        </c:when>
                        <c:otherwise>
                            <td style="color: crimson">入住</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade" id="freeroom">
        <table class="table table-bordered table-width">
            <thead>
            <tr>
                <th>名称</th>
                <th>状态</th>
                <th>价格</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.rooms}" var="room">
                <c:if test="${room.status==Room.FREE}">
                    <tr>
                        <td>${room.rname}</td>
                        <td style="color:green"><a href="/orderCheck.do?rID=${room.rID}">空闲</a></td>
                        <td>${room.rcost}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade" id="room">
        <table class="table table-bordered table-width">
            <caption>今日房价${rmin}-${rmax}元/天</caption>
            <thead>
            <tr>
                <th>物品名称</th>
                <th>价格</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.items}" var="it">
                <tr>
                    <td>${it.iname}</td>
                    <td>${it.icost}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<!-- 底部内容 -->
<!-- <div class="jumbotron text-center" style="margin-bottom:0">
  <p>版权所有</p>
</div> -->
</body>
</html>