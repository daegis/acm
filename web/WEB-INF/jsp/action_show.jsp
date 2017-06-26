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
    <title>查看事件</title>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
<table border="1" align="center">
    <tr>
        <td width="80px">事件id</td>
        <td width="200px">事件名称</td>
        <td width="80px">开始日期</td>
        <td width="80px">天数</td>
        <td width="180px">所用车辆</td>
        <td width="120px">收费</td>
        <td width="120px"></td>
    </tr>
    <c:if test="${actionList==null}">
        <tr>
            <td colspan="6">没有活动</td>
        </tr>
    </c:if>
    <c:if test="${actionList!=null}">
        <c:forEach items="${actionList}" var="a">
            <tr>
                <td>${a.aid}</td>
                <td>${a.aname}</td>
                <td>${a.adate}</td>
                <td>${a.aday}</td>
                <td>${a.abus}</td>
                <td>${a.aprice}</td>
                <td><a href="${pageContext.request.contextPath}/detailedAction?aid=${a.aid}"><input type="button"
                                                                                                    value="查看详情"></a>
                </td>
            </tr>
        </c:forEach>
    </c:if>

</table>
</body>
</html>
