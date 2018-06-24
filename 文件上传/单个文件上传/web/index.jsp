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
    <s:submit/>
</s:form>

<%--<form id="upload" name="upload" action="<s:url action="upload"/>" method="POST" enctype="multipart/form-data">
    <table class="wwFormTable">
        <tr>
            <td class="tdLabel"><label for="upload_head" class="label">头像:</label></td>
            <td
                    class="tdInput"
            ><input type="file" name="head" id="upload_head"/></td>
        </tr>


        <tr>
            <td class="tdLabel"><label for="upload_headDesc" class="label">headDesc:</label></td>
            <td
                    class="tdInput"
            ><input type="text" name="headDesc" value="" id="upload_headDesc"/></td>
        </tr>


        <tr>
            <td colspan="2"><div class="formButton"><input type="submit" value="Submit" id="upload_0"/>
            </div></td>
        </tr>


    </table></form>--%>
</body>
</html>
