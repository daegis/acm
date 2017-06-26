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
    <title>添加人员</title>
</head>
<%@ include file="header.jsp" %>
<body>
<hr>
添加人员<a href="${pageContext.request.contextPath}/welcome"><input type="button" value="返回首页"></a>
<hr>
<form action="${pageContext.request.contextPath}/addClient" method="post">
    <table border="1" align="center">
        <tr>
            <td width="100px">人员昵称</td>
            <td width="222px"><input type="text" name="cnickname"></td>
            <td width="500px"><font color="red">**必填**</font>填写人员的昵称,真实姓名到人员管理界面进行添加</td>
        </tr>

        <tr>
            <td>电话</td>
            <td><input type="text" maxlength="11" name="cphone"></td>
            <td><font color="red">**必填**</font>填写人员联系方式</td>
        </tr>
        <tr>
            <td>报名活动</td>
            <td colspan="2">
                <c:forEach items="${actionList}" var="ac">
                    <input type="checkbox" name="joints" value="${ac.aid}">${ac.aname}<br>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td colspan="2">
                <textarea style="width: 400px;height: 200px" name="cnote">这个人看起来很正常</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="提交人员信息"></td>
        </tr>


    </table>
</form>

</body>
</html>
