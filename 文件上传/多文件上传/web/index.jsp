<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/24
  Time: 下午5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<s:form action="upload" method="POST" enctype="multipart/form-data">
    <s:file name="head" label="头像"/>
    <s:textfield name="headDesc" label="headDesc"/>

    <s:file name="head" label="头像"/>
    <s:textfield name="headDesc" label="headDesc"/>

    <s:file name="head" label="头像"/>
    <s:textfield name="headDesc" label="headDesc"/>
    <s:submit/>
</s:form>
</body>
</html>
