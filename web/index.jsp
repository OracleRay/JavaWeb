<%--
    1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
    2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
    3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
    4.page：配置JSP页面的
            * errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
            * isErrorPage：标识当前也是是否是错误页面。
                * true：是，可以使用内置对象exception
                * false：否。默认值。不可以使用内置对象exception
    5. include    ： 页面包含的。导入页面的资源文件
            * <%@include file="top.jsp"%>
    6. taglib    ： 导入资源
            * <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                * prefix：前缀，自定义的
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h1>hello jsp!</h1>
  </body>
</html>
