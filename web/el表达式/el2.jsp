<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域对象</title>
</head>
<body>
  <%
    request.setAttribute("name","张三");
    request.setAttribute("age","李四");
    session.setAttribute("name","李四");
  %>
${name}
${sessionScope.name}
  </body>
</html>
