package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo2", value = "/RequestDemo2")
public class 获取请求头 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();              //获取所有请求头名称
        while(headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + "---" + header);
        }

        String userAgent = request.getHeader("user-agent");                    //判断浏览器版本
        if(userAgent.contains("Chrome")){
            System.out.println("谷歌浏览器打开了。。。");
        }else if(userAgent.contains("IE")){
            System.out.println("IE浏览器打开了。。。");
        }

        String referer = request.getHeader("referer");                         //链接来源
        System.out.println(referer);
        if(referer.contains("/Web")){                     //防盗链
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("播放电影");
            System.out.println("播放电影");
        }else{
            System.out.println("呵呵!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
