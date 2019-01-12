<%@ page import="com.fhx.servicelmp.OrderServicelmp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fhx.entity.Room" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="com.fhx.entity.Customer" %>
<%@ page import="com.fhx.servicelmp.UserServicelmp" %>
<%@ page import="com.fhx.entity.User" %>
<%@ page import="com.fhx.service.UserService" %>
<%@ page import="com.fhx.entity.Item" %><%--
  Created by IntelliJ IDEA.
  User: FHX
  Date: 2018/12/23
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="/js/index.js"></script>
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
                <li class="active">
                    <a href="#">主页</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- 表格 -->
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#home" data-toggle="tab">
            客房管理<span class="badge pull-right">${freenum}</span>
        </a>
    </li>
    <li><a href="#ios" data-toggle="tab">物品增加</a></li>
    <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">人员管理
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <%  User user=(User) session.getAttribute("user");
                if(user.getRole()==2){%>
            <li><a href="#jmeter" tabindex="-1" data-toggle="tab">新增员工</a></li>
            <%}%>
            <li><a href="#ejb" tabindex="-1" data-toggle="tab">新增客户</a></li>
        </ul>
    </li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <!-- 表格 -->
        <!-- 表格 -->
        <table class="table table-bordered table-width">
            <jsp:useBean id="time" class="com.fhx.util.Time"/>
            <caption>${time.nowTime}</caption>
            <thead>
            <tr>
                <th>名称</th>
                <th>价格</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Room> rooms=(List<Room>)session.getAttribute("rooms");
                for(Room room:rooms){
            %>
                <tr>
                    <td><%=room.getRname()%></td>
                    <td><%=room.getRcost()%></td>
                    <% OrderServicelmp osi=(OrderServicelmp) session.getAttribute("osi");
                        UserServicelmp usi=(UserServicelmp) session.getAttribute("usi");
                        if(room.getStatus()==Room.FREE){%>
                            <td style="color: green">空闲</td>
                            <td></td>
                        <%}else if (room.getStatus()==Room.ORDER){
                           %>
                            <td style="color: #31b0d5">预约</td>
                            <td><a href="/change.do?riD=<%=room.getrID()%>">取消预约</a>&nbsp;&nbsp;<a href="/home.do?riD=<%=room.getrID()%>" style="color: red">入住</a></td>
                        <%}else{%>
                            <td style="color: crimson">入住</td>
                            <td><a href="/change.do?riD=<%=room.getrID()%>">退房</a></td>
                       <%}%>
                </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade" id="ios">
        <%--<进货>--%>
            <table class="table table-bordered table-width">
                <caption>已有物品</caption>
                <tr>
                    <td>物品</td>
                    <td>数量</td>
                    <td>单价</td>
                </tr>
                <%
                    List<Item> items=(List<Item>) session.getAttribute("items");
                    for (Item item:items){
                %>
                <tr>
                    <td><%=item.getIname()%></td>
                    <td><%=item.getStock()%></td>
                    <td><%=item.getIcost()%></td>
                </tr>
                <%}%>
            </table>
        <form action="additem" method="post">
        <table class="table table-bordered table-width" id="mytable">
            <tr>
                <td>物品</td>
                <td>数量</td>
                <td>单价</td>
                <td>单位</td>
                <td><input type="submit" class="btn btn-primary" value="+"></td>
            </tr>
            <tr>
                <td><input name="iname"></td>
                <td><input name="inum"></td>
                <td><input name="icost"></td>
                <td><input name="unit"></td>
            </tr>
        </table>
        </form>
    </div>
    <div class="tab-pane fade" id="jmeter">
        <%--新增员工--%>
            <form action="addUser" method="post">
                <table class="table table-bordered table-width">
                    <tr>
                        <td>用户ID</td>
                        <td><input name="username"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td>
                            <input name="password">
                        </td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-primary" value="添加">
            </form>
    </div>
    <div class="tab-pane fade" id="ejb">
        <form action="addCus.do" method="post">
            <table class="table table-bordered table-width">
                <tr>
                    <td>用户ID</td>
                    <td><input name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input name="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        姓名
                    </td>
                    <td><input name="cname"></td>
                </tr>
                <tr>
                    <td>
                        身份证
                    </td>
                    <td><input name="cID"></td>
                </tr>
                <tr>
                <td>电话</td>
                    <td><input name="tel"></td>
                </tr>
            </table>
            <input type="submit" class="btn btn-primary" value="添加客户">
        </form>
    </div>
</div>

<!-- 底部内容 -->
<!-- <div class="jumbotron text-center" style="margin-bottom:0">
  <p>版权所有</p>
</div> -->
</body>
<script type="text/javascript" src="../js/time.js"></script>
</html>
