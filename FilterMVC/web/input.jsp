<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/23
  Time: 下午12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
<form action="<%=request.getContextPath()%>product-save.action" method="post">
    姓名：<input name="username" type="text">
    <button type="submit">提交</button>
</form>
</body>
</html>
