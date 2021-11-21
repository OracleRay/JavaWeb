package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cookieDemo1", value = "/cookieDemo1")
public class ����cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg","cookie!");               //����cookie
        cookie.setMaxAge(30);                                   //��cookie�洢��Ӳ�̣�30s���Զ�ɾ��������ΪĬ��ֵ��0Ϊ����ɾ��
        cookie.setPath("/");                        //��ǰ��������������Ŀ������cookie
        response.addCookie(cookie);                               //����cookie
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
