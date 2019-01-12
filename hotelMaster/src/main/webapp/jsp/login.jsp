<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta charset="UTF-8">
    <script src="/js/jquery-3.1.0.min.js"></script>
    <script src="/js/vue.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <style href="/css/bootstrap.min.css"></style>
    <link rel="stylesheet" type="text/css" href="/css/login.css" />
    <script src="/js/login.js"></script>
</head>
<body>
<div id="login">

    <div id="login_head"><h1>宾馆客房管理系统登录</h1></div>
    <c:if test="${msg!=null}">
        <p style="color: red">${msg}</p>
    </c:if>
    <p><input id="username" type="text"  name="userid" placeholder="帐号" /></p>
    <p><input id="pwd" type="password" name="password" placeholder="密码" /></p>
    <p><select id="select_role" name="role">
        <option value="0">用户</option>
        <option value="1">员工</option>
        <option value="2">管理员</option>
    </select>
    <p> <input type="button" id="submit" value="登录" onclick="checkLogin()"/></p>
</div>
</body>
</html>