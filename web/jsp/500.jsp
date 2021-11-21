<%--
  Created by IntelliJ IDEA.
  domain.User: 雷东宸
  Date: 2021/9/12
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>500错误页面</title>
</head>
<body>
  <h1>页面发送错误了。。。</h1>
  <%
      String message = exception.getMessage();
      out.print(message);
  %>
  </body>
</html>
