<%--
  Created by IntelliJ IDEA.
  User: XIAN. Yingda
  Date: 2017/6/25
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理平台</title>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
这里是管理平台
<hr>
事件管理<br>
<a href="${pageContext.request.contextPath}/action_add">添加一个事件</a><br>
<a href="${pageContext.request.contextPath}/action_show">查看所有事件</a><br>

</body>
</html>
