package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo5", value = "/RequestDemo5")
public class ����ת�� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","Ray");
        request.getRequestDispatcher("/RequestDemo6").forward(request,response);         //���������ã�·������Ҫ������Ŀ¼
        System.out.println("RequestDemo5�������ˡ�");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
