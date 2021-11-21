package session;

/**
 * idea只能实现session钝化不能实现活化
 * tomcat本地服务器可实现钝化与活化
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sessionDemo1", value = "/sessionDemo1")
public class 共享数据 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();                 //获取httpSession对象
        session.setAttribute("msg","hello session");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
