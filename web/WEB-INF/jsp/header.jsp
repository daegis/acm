<%--
  Created by IntelliJ IDEA.
  User: XIAN. Yingda
  Date: 2017/6/25
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${user==null}">
    未登录
</c:if>
<c:if test="${user!=null}">
    当前登录用户:${user.username}
</c:if>
</body>
</html>
