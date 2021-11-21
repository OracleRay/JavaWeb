package servletContext;
/**
 * String b = context.getRealPath("/b.txt");//webĿ¼����Դ����
 *
 * String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INFĿ¼�µ���Դ����
 *
 * String a = context.getRealPath("/WEB-INF/classes/a.txt");//srcĿ¼�µ���Դ����
 *
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletContextDemo5", value = "/servletContextDemo5")
public class ��ȡ�ļ���ʵ·�� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();               //httpServlet�µ�servletContext
        String a = context.getRealPath("/WEB-INF/classes/a.txt");           //srcĿ¼�µ�a.txt
        // /���� D:\Program Files\JavaLibraries\apache-tomcat-9.0.52\webapps\idea_web\
        System.out.println(a);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
