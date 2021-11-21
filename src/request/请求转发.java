package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo5", value = "/RequestDemo5")
public class 请求转发 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","Ray");
        request.getRequestDispatcher("/RequestDemo6").forward(request,response);         //给服务器用，路径不需要加虚拟目录
        System.out.println("RequestDemo5被访问了。");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
