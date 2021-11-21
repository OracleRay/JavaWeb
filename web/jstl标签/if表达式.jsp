<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("123456");
    request.setAttribute("list",list);
    request.setAttribute("number","5");
%>
<%--test为true显示，false不显示--%>
<c:if test="${not empty list}">
    这是一条遍历。。。
</c:if>
<br>
<c:if test="${number % 2 != 0}">
    ${number}是奇数
</c:if>
  </body>
</html>
