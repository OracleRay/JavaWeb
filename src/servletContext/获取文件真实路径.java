package servletContext;
/**
 * String b = context.getRealPath("/b.txt");//web目录下资源访问
 *
 * String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
 *
 * String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
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
public class 获取文件真实路径 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();               //httpServlet下的servletContext
        String a = context.getRealPath("/WEB-INF/classes/a.txt");           //src目录下的a.txt
        // /代表 D:\Program Files\JavaLibraries\apache-tomcat-9.0.52\webapps\idea_web\
        System.out.println(a);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
