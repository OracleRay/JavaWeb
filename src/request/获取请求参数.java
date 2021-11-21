package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "RequestDemo4", value = "/RequestDemo4")
public class ��ȡ������� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                      //get��ʽ�������룬post������
        String username = request.getParameter("username");            //��ȡ�������
        System.out.println(username);

        String[] hobby = request.getParameterValues("hobby");             //��ȡ�����������
        for(String hobbies:hobby){
            System.out.println(hobbies);
        }

        Map<String, String[]> parameterMap = request.getParameterMap();             //��ȡ���в���map����
        Set<String> keySet = parameterMap.keySet();
        for(String name:keySet){
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value:values){
                System.out.println(value);
            }
            System.out.println("-----------------------------------------------");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
