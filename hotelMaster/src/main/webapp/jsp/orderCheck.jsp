<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FHX
  Date: 2019/1/7
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单确认页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="../js/orderCheck.js"></script>
</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/order.html">HotelMaster</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/loginBack.html"><span class="glyphicon glyphicon-log-in"></span>退出</a></li>
        </ul>
    </div>

</nav>
<div>
    <form action="orderCheck.do?rID=${room.rID}" method="post">
        <table class="table table-bordered table-width" >
            <caption><span id="time">订单页面</span></caption>
            <tr>
                <td>房间</td>
                <td>${room.rname}</td>
            </tr>
            <tr>
                <td>住宿天数</td>
                <td><input type="text" name="day" id="day" value="1" onkeyup="value=value.replace(/[^\d]/g,'')" >天</td>
            </tr>
            <tr>
                <td>房型花费</td>
                <td id="dc">${room.rcost}元/天</td>
            </tr>
            <tr>
                <td>租借开始时间</td>
                <td><input type="date" name="time"></td>
            </tr>
            <tr>
                <td>客户姓名</td>
                <td>${sessionScope.customer.cname}</td>
            </tr>
            <tr>
                <td>客户身份证</td>
                <td>${sessionScope.customer.cID}</td>
            </tr>
        </table>
        <p>你要选购的东西有</p>
        <table class="table table-bordered" style="width: 900px" id="itemTable">
            <tr>
                <td>物品名称</td>
                <td>物品价格</td>
                <td>物品购买数量</td>
                <td>商品总价</td>
            </tr>
            <c:forEach items="${sessionScope.items}" var="it">
                <tr>
                    <td>${it.iname}</td>
                    <td>${it.icost}元/${it.unit}</td>
                    <td><input type="text" id="${it.iiD}" name="num" value="1"></td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
        <div id="end" style="display: none">
            <p>总金额为<input id="sum" name="total" readonly >元，预支付定金<input type="text" name="bargin" value="0"><input type="submit" class="btn btn-primary" value="确认"></p>
        </div>
    </form>
</div>
<button id="check" class="btn btn-primary" onclick="check()">完成订单</button>
</body>

</html>
