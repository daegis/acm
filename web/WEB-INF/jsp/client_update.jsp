<jsp:useBean id="action" scope="request" type="red.sif.beans.Action"/>
<jsp:useBean id="client" scope="request" type="red.sif.beans.ActionClient"/>
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
    <title>更新人员信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script>

    </script>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
编辑人员页面<a href="${pageContext.request.contextPath}/detailedAction?aid=${action.aid}"><input type="button" value="返回该事件"></a>
<hr>
<div align="center">
    <form id="formid">
        <table>
            <tr hidden>
                <td>事件id:</td>
                <td><input type="text" value="${action.aid}" name="aid"></td>
            </tr>
            <tr>
                <td>事件名称:</td>
                <td><input type="text" value="${action.aname}" disabled name="aname"></td>
            </tr>
            <tr>
                <td>日期:</td>
                <td><input type="date" value="${action.adate}" disabled name="adate"></td>
            </tr>
            <tr>
                <td>天数:</td>
                <td><input type="text" value="${action.aday}" disabled name="aday"></td>
            </tr>
            <tr>
                <td>交通工具:</td>
                <td><input type="text" value="${action.abus}" disabled name="abus"></td>
            </tr>
            <tr>
                <td>当前人数:</td>
                <td><input type="text" value="${action.acount}" disabled></td>
            </tr>
            <tr>
                <td>价格:</td>
                <td><input type="text" value="${action.aprice}" disabled name="aprice"></td>
            </tr>
            <tr>
                <td>预计花费:</td>
                <td><input type="text" value="${action.acost}" disabled name="acost"></td>
            </tr>
        </table>
    </form>
</div>
<hr>
<div style="text-align: center">修改人员信息</div>
<form id="clientForm">
    <input hidden name="aid" value="${action.aid}">
    <input hidden name="cid" value="${client.cid}">
    <table border="1" align="center">
        <tr>
            <td colspan="2">人员信息</td>
            <td colspan="2">活动信息</td>
        </tr>
        <tr>
            <td width="144px">昵称</td>
            <td width="355px"><input type="text" name="cnickname" value="${client.cnickname}"></td>
            <td width="144px">活动序号</td>
            <td width="355px"><input type="text" name="acorder" value="${client.acorder}" disabled></td>
        </tr>
        <tr>
            <td>真实姓名</td>
            <td><input type="text" name="cname" value="${client.cname}"></td>
            <td>报名时间</td>
            <td><input type="text" name="acdate" value="${client.acdate}" disabled></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="cphone" value="${client.cphone}"></td>
            <td>应缴款项</td>
            <td><input type="text" name="acprice" value="${client.acprice}" disabled></td>
        </tr>
        <tr>
            <td>身份证号</td>
            <td><input type="text" name="cidnum" value="${client.cidnum}"></td>
            <td>折扣</td>
            <td><input type="text" name="acdiscount" value="${client.acdiscount}"></td>
        </tr>
        <tr>
            <td>来自哪里</td>
            <td><input type="text" name="clocation" value="${client.clocation}"></td>
            <td>预付款</td>
            <td><input type="text" name="acprecharge" value="${client.acprecharge}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="cage" value="${client.cage}"></td>
            <td>缴费方式</td>
            <td><select name="acpremethod">
                <option value="${client.acpremethod}">${client.acpremethod}</option>
                <option value="未缴费">--未缴费--</option>
                <option value="微信转账">微信转账</option>
                <option value="支付宝">支付宝</option>
                <option value="现金">现金</option>
                <option value="工商银行">工商银行</option>
                <option value="建设银行">建设银行</option>
                <option value="农业银行">农业银行</option>
                <option value="招商银行">招商银行</option>
                <option value="其他银行">其他银行</option>
            </select></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="cgender" value="${client.cgender}"></td>
            <td>欠款</td>
            <td><input type="text" disabled value="${client.acleft}"></td>
        </tr>
        <tr>
            <td>备注信息</td>
            <td><textarea style="width: 400px;height: 150px" name="cnote">${client.cnote}</textarea></td>
            <td colspan="2">
                <input type="button" value="提交修改" style="width: 100%;height: 150px;" id="submitBtn">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    $(function () {
        $("#submitBtn").click(function () {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/updateClientAction",
                data: $("#clientForm").serialize(),// 序列化表单值
                async: false,
                error: function (request) {
                    alert("服务器连接超时,稍后重试");
                },
                success: function (message) {
                    alert(message);
                }
            })
        })
    })
</script>
</html>
