<%--
  Created by IntelliJ IDEA.
  User: XIAN. Yingda
  Date: 2017/6/19
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网站通知</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script>
        $(function () {
            $("#second").text(3);
            setInterval(function () {
                var $count = $("#second");
                var number = $count.text();
                if (number >= 0) {
                    number--;
                    $count.text(number);
                    if (number == 0) {
                        self.location = "${pageContext.request.contextPath}/index.jsp";
                    }
                }
            }, 1000)
        })
    </script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<h1 align="center">
    <c:if test="${errorMessage==null}">
        没有通知
    </c:if>
    <c:if test="${errorMessage!=null}">
        ${errorMessage}
    </c:if>
</h1>
<br>
<br>
<h3 align="center">
    网站将在<span id="second"></span>秒内跳转到登录页面
</h3>
</body>
</html>
