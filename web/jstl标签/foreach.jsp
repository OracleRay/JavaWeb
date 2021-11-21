<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
  <c:forEach begin="1" end="10" var="i" step="2" varStatus="status">
      ${i} ${status.index} ${status.count} <br>
  </c:forEach>

<%
    List list = new ArrayList();
    request.setAttribute("list",list);
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
%>
<hr>
  <br>

  <c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str} <br>
  </c:forEach>
</body>
</html>
