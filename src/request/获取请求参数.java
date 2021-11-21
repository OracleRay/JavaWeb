package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "RequestDemo4", value = "/RequestDemo4")
public class 获取请求参数 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");                      //get方式不会乱码，post会乱码
        String username = request.getParameter("username");            //获取请求参数
        System.out.println(username);

        String[] hobby = request.getParameterValues("hobby");             //获取请求参数数组
        for(String hobbies:hobby){
            System.out.println(hobbies);
        }

        Map<String, String[]> parameterMap = request.getParameterMap();             //获取所有参数map集合
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
