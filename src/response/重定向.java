package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "responseServletDemo1", value = "/responseServletDemo1")
public class 重定向 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1!!!");

//        response.setStatus(302);                               //设置状态码为302(重定向)
//        response.setHeader("location","/Web/responseServletDemo2");            // 设置响应头location

        String contextPath = request.getContextPath();                  //动态获取虚拟目录
        //简单重定向方法
        response.sendRedirect(contextPath + "/responseServletDemo2");               //给客户端用，需要加虚拟目录
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
