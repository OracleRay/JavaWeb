package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo2", value = "/RequestDemo2")
public class ��ȡ����ͷ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();              //��ȡ��������ͷ����
        while(headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + "---" + header);
        }

        String userAgent = request.getHeader("user-agent");                    //�ж�������汾
        if(userAgent.contains("Chrome")){
            System.out.println("�ȸ���������ˡ�����");
        }else if(userAgent.contains("IE")){
            System.out.println("IE��������ˡ�����");
        }

        String referer = request.getHeader("referer");                         //������Դ
        System.out.println(referer);
        if(referer.contains("/Web")){                     //������
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("���ŵ�Ӱ");
            System.out.println("���ŵ�Ӱ");
        }else{
            System.out.println("�Ǻ�!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
