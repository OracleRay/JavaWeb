package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseServletDemo3", value = "/responseServletDemo3")
public class ����ַ��� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");         //��������Ĭ�ϱ���
//        response.setHeader("content-type","text/html;utf-8");         //�����������Ӧͷ��Ϣ�е�Ĭ�ϱ���
        response.setContentType("text/html;charset=utf-8");              //�򵥵���ʽȥ�������������
        PrintWriter pw = response.getWriter();
        pw.write("<h1>�����response��</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
