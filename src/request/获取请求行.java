package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo1", value = "/RequestDemo1")
public class 获取请求行 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("请求方式：" + method);

        String contextPath = request.getContextPath();
        System.out.println("虚拟目录：" + contextPath);                 //重要

        String servletPath = request.getServletPath();
        System.out.println("servelet路径：" + servletPath);

        String queryString = request.getQueryString();
        System.out.println("get方式请求参数：" + queryString);

        String requestURI = request.getRequestURI();
        System.out.println("URI:" + requestURI);                         //重要
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL:" + requestURL);

        String protocol = request.getProtocol();
        System.out.println("协议和版本：" + protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户机IP地址：" + remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
