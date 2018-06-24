<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/24
  Time: 下午1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>

<s:debug/>

<%-- 国际化动态切换 --%>
<a href="i18n.action?request_locale=en_US">English</a>
<a href="i18n.action?request_locale=en_CN">中文</a>

<%-- 取带占位符的国际化资源方式一【推荐】 --%>
<s:text name="time">
    <s:param value="date"/>
</s:text>

<br>

<%-- 取带占位符的国际化资源方式二 --%>
<s:text name="time2"/>

<br>

<s:form>

    <%-- 方式一 --%>
    <s:textfield name="username" label="%{getText('username')}"/>
    <s:textfield name="password" label="%{getText('password')}"/>

    <%-- 方式二【推荐】 --%>
    <s:textfield name="username" key="username"/>
    <s:textfield name="password" key="password"/>
    <s:submit key="submit"/>

</s:form>
</body>
</html>
