<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/24
  Time: 上午1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<s:iterator value="#request.books" var="book">
    <s:property value="#book.name"/>
</s:iterator>
</body>
</html>
