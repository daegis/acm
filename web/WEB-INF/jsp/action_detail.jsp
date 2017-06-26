<jsp:useBean id="action" scope="request" type="red.sif.beans.Action"/>
<%--
  Created by IntelliJ IDEA.
  User: XIAN. Yingda
  Date: 2017/6/26
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>事件详情</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script>
        $(function () {
            $("#sbtn").click(function () {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/updateAction",
                    data: $("#formid").serialize(),// 序列化表单值
                    async: false,
                    error: function (request) {
                        alert("Connection error");
                    },
                    success: function (message) {
                        alert(message);
                    }
                })
            })
        })
    </script>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
事件详情页面<a href="${pageContext.request.contextPath}/action_show"><input type="button" value="返回事件首页"></a>
<hr>
<form id="formid">
    <table>
        <tr hidden>
            <td>事件id:</td>
            <td><input type="text" value="${action.aid}" name="aid"></td>
        </tr>
        <tr>
            <td>事件名称:</td>
            <td><input type="text" value="${action.aname}" name="aname"></td>
        </tr>
        <tr>
            <td>日期:</td>
            <td><input type="date" value="${action.adate}" name="adate"></td>
        </tr>
        <tr>
            <td>天数:</td>
            <td><input type="text" value="${action.aday}" name="aday"></td>
        </tr>
        <tr>
            <td>交通工具:</td>
            <td><input type="text" value="${action.abus}" name="abus"></td>
        </tr>
        <tr>
            <td>当前人数:</td>
            <td><input type="text" value="${action.acount}" disabled></td>
        </tr>
        <tr>
            <td>价格:</td>
            <td><input type="text" value="${action.aprice}" name="aprice"></td>
        </tr>
        <tr>
            <td>预计花费:</td>
            <td><input type="text" value="${action.acost}" name="acost"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="提交修改" id="sbtn"></td>
        </tr>
    </table>
</form>

</body>
</html>
