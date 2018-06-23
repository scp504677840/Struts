<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/23
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>

<h1>欢迎：${sessionScope.name}</h1>
<br>

<h1>在线人数：${applicationScope.count}</h1>
<br>

<a href="logout.action">登出</a>
</body>
</html>
