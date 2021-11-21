<%@ page import="test.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>练习</title>
    <style>
        table{
            border:1px solid;
        }
        td{
            border:1px solid;
        }
        #tr1{
            background-color: red;
        }
        #tr2{
            background-color: greenyellow;
        }
    </style>
</head>
<body>
<%
    List list = new ArrayList<>();
    list.add(new domain.User("张三",23,new Date()));
    list.add(new domain.User("李四",24,new Date()));
    list.add(new domain.User("王五",25,new Date()));
    request.setAttribute("list",list);
%>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr id="tr1">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 != 0}">
            <tr id="tr2">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
