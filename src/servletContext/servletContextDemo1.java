package servletContext;

/**
 * �����������webӦ�ã����Ժͳ��������(������)��ͨ��
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "servletContextDemo1", value = "/servletContextDemo1")
public class servletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context1 = request.getServletContext();
        ServletContext context2 = this.getServletContext();               //httpServlet�µ�servletContext
        System.out.println(context1);
        System.out.println(context2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
