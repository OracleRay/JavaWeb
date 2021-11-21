package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "responseServletDemo1", value = "/responseServletDemo1")
public class �ض��� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1!!!");

//        response.setStatus(302);                               //����״̬��Ϊ302(�ض���)
//        response.setHeader("location","/Web/responseServletDemo2");            // ������Ӧͷlocation

        String contextPath = request.getContextPath();                  //��̬��ȡ����Ŀ¼
        //���ض��򷽷�
        response.sendRedirect(contextPath + "/responseServletDemo2");               //���ͻ����ã���Ҫ������Ŀ¼
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
