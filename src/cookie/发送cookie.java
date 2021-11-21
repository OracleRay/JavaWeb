package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cookieDemo1", value = "/cookieDemo1")
public class 发送cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg","cookie!");               //创建cookie
        cookie.setMaxAge(30);                                   //将cookie存储到硬盘，30s后自动删除。负数为默认值，0为立马删除
        cookie.setPath("/");                        //当前服务器下所有项目都共享cookie
        response.addCookie(cookie);                               //发送cookie
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
