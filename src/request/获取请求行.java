package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo1", value = "/RequestDemo1")
public class ��ȡ������ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("����ʽ��" + method);

        String contextPath = request.getContextPath();
        System.out.println("����Ŀ¼��" + contextPath);                 //��Ҫ

        String servletPath = request.getServletPath();
        System.out.println("servelet·����" + servletPath);

        String queryString = request.getQueryString();
        System.out.println("get��ʽ���������" + queryString);

        String requestURI = request.getRequestURI();
        System.out.println("URI:" + requestURI);                         //��Ҫ
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL:" + requestURL);

        String protocol = request.getProtocol();
        System.out.println("Э��Ͱ汾��" + protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println("�ͻ���IP��ַ��" + remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
