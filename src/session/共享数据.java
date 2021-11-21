package session;

/**
 * ideaֻ��ʵ��session�ۻ�����ʵ�ֻ
 * tomcat���ط�������ʵ�ֶۻ���
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sessionDemo1", value = "/sessionDemo1")
public class �������� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();                 //��ȡhttpSession����
        session.setAttribute("msg","hello session");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
