<%--
  Created by IntelliJ IDEA.
  User: XIAN. Yingda
  Date: 2017/6/25
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加事件</title>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
添加事件<br>
<form method="post" action="${pageContext.request.contextPath}/addAction">
    <table>
        <tr>
            <td>事件名称<font color="red">必填</font></td>
            <td><input type="text" name="aname"></td>
        </tr>
        <tr>
            <td>事件日期</td>
            <td><input type="date" name="adate"></td>
        </tr>
        <tr>
            <td>天数</td>
            <td><input type="text" name="aday"></td>
        </tr>
        <tr>
            <td>交通工具</td>
            <td><input type="text" name="abus"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="aprice"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
