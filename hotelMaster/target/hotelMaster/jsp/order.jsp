<%--
  Created by IntelliJ IDEA.
  User: FHX
  Date: 2019/1/6
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fhx.entity.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fhx.entity.Order" %>
<%@ page import="com.fhx.util.Time" %>
<%@ page import="com.fhx.entity.ItemUsing" %>
<%@ page import="com.fhx.servicelmp.UserServicelmp" %>
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="/js/orderCheck.js"></script>
</head>
<body>
<!-- 顶部导航栏 -->
<c:if test="${msg!=null}">
    <script> alert("${msg}");</script>
</c:if>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">HotelMaster</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">主页</a>
                </li>
                <li><a href="userInfo.html">关于我</a></li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> 我</a></li>  -->
            <li><a href="/user/loginBack.html"><span class="glyphicon glyphicon-log-in"></span>退出</a></li>
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
    <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">我的预约
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <li><a href="#jmeter" tabindex="-1" data-toggle="tab">预订</a></li>
            <li><a href="#ejb" tabindex="-1" data-toggle="tab">物品管理</a></li>
        </ul>
    </li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <!-- 表格 -->
        <table class="table table-bordered table-width">
            <jsp:useBean id="time" class="com.fhx.util.Time"/>
            <caption>${time.nowTime}</caption>
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
                            <td style="color: green"><a href="/orderCheck.html?rID=${room.rID}">空闲</a></td>
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
            <caption>空闲客房</caption>
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
                        <td style="color: green"><a href="/orderCheck.html?rID=${room.rID}">空闲</a></td>
                        <td>${room.rcost}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade" id="jmeter">
        <%--我的预订--%>
        <table class="table table-bordered table-width">
            <caption>${sessionScope.customer.cname}的预订</caption>
            <thead>
                <tr>
                    <td>房间名称</td>
                    <td>预订时间</td>
                    <td>花费</td>
                    <td>订金</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
            <%
                int j;
                List<Order> orders=(List<Order>) session.getAttribute("orders");
                List<Room> rooms=(List<Room>)session.getAttribute("rooms");
                if(orders!=null){
                for(int i=0;i<orders.size();i++){
                    Order order=orders.get(i);
                    if(order.getOtype()==0){
                    for (j=0;j<rooms.size();j++)
                        if(Integer.parseInt(order.getrID())==rooms.get(j).getrID())break;
                        if(j!=rooms.size()){
            %>
                <tr id="<%=order.getoNo()%>">
                    <td><%=rooms.get(j).getRname()%></td>
                    <td><%=new Time().Date2String(order.getOtime())%></td>
                    <td><%=order.getTotal()%></td>
                    <td><%=order.getBargin()%></td>
                    <td><button onclick="pay(<%=order.getoNo()%>)" class="btn btn-primary">付清</button></td>
                </tr>
            <%
                        }
                }
                }
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade" id="ejb">
        <%
            int k;
            if(orders!=null){
            for(int i=0;i<orders.size();i++){
                Order order=(Order)orders.get(i);
                if(order.getOtype()==0){
                    Room room=new Room();
                    for(k=0;k<rooms.size();k++){
                        room=rooms.get(k);
                        if(room.getrID()==Integer.parseInt(order.getrID()))break;
                    }
        %>
        <table class="table table-bordered table-width">
            <caption><%=room.getRname()%></caption>
            <thead>
                <tr>
                    <td>物品</td>
                    <td>数量</td>
                    <td>单价</td>
                    <td>物品总价</td>
                    <td><a href="/itemback.do?oNo=<%=order.getoNo()%>">物品归还</a></td>
                </tr>
            </thead>
            <tbody>
            <%
                UserServicelmp usi=(UserServicelmp)session.getAttribute("usi");
                List<ItemUsing> itemUsings=usi.findItemsInUse(order.getoNo());
                if(itemUsings!=null){
                    for (int y=0;y<itemUsings.size();y++){
                        ItemUsing itemUsing=(ItemUsing)itemUsings.get(y);
            %>
                <tr>
                    <td><%=itemUsing.getIname()%></td>
                    <td><%=(int)(itemUsing.getIecost()/itemUsing.getIcost())+itemUsing.getUnit()%></td>
                    <td><%=itemUsing.getIcost()+"元/"+itemUsing.getUnit()%></td>
                    <td><%=itemUsing.getIecost()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
                <%}}
            } }%>
    </div>
</div>

</body>
<script type="text/javascript" src="../js/time.js"></script>
</html>
