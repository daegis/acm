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
<hr>
<div style="text-align: center">参与人员</div>
<table border="1" align="center">
    <tr>
        <td>活动序号</td>
        <td>cid</td>
        <td>昵称</td>
        <td>姓名</td>
        <td>电话</td>
        <td>身份证号</td>
        <td>所在地</td>
        <td>年龄</td>
        <td>性别</td>
        <td>报名时间</td>
        <td>价格</td>
        <td>折扣</td>
        <td>预付</td>
        <td>缴费方式</td>
        <td>人员状态</td>
    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.acorder}</td>
            <td>${client.cid}</td>
            <td>${client.cnickname}</td>
            <td>${client.cname}</td>
            <td>${client.cphone}</td>
            <td>${client.cidnum}</td>
            <td>${client.clocation}</td>
            <td>${client.cage}</td>
            <td>${client.cgender}</td>
            <td>${client.acdate}</td>
            <td>${client.acprice}</td>
            <td>${client.acdiscount}</td>
            <td>${client.acprecharge}</td>
            <td>${client.acpremethod}</td>
            <td>${client.acisready}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
