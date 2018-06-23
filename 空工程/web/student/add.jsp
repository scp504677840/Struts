<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/23
  Time: 下午4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="<s:url namespace="/student" action="save"/>" method="post">
    <label>
        姓名：
        <input name="name" type="text">
    </label>
    <button type="submit">提交</button>
</form>
</body>
</html>
