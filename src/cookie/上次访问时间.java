package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cookieDemo3", value = "/cookieDemo3")
public class 上次访问时间 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if(name.equals("lastTime")){
                    flag = true;

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");     //获取中国时间
                    String last_Time = sdf.format(date);

                    last_Time = URLEncoder.encode(last_Time, "utf-8");      //对cookie值进行url编码，使其可以有空格输入

                    cookie.setValue(last_Time);                     //设置cookie值
                    cookie.setMaxAge(60*60*24*30);               //设置cookie存活时间为一个月
                    response.addCookie(cookie);                       //发送cookie

                    String value = cookie.getValue();                 //获取cookie值

                    value = URLDecoder.decode(value, "utf-8");            //对cookie值进行解码

                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");
                    break;
                }
            }
        }
        if(cookies == null || cookies.length == 0 || flag == false){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");     //获取中国时间
            String last_Time = sdf.format(date);

            last_Time = URLEncoder.encode(last_Time, "utf-8");      //对cookie值进行url编码，使其可以有空格输入

            Cookie cookie = new Cookie("lastTime",last_Time);
            cookie.setMaxAge(60*60*24*30);               //设置cookie存活时间为一个月
            response.addCookie(cookie);                       //发送cookie

            response.getWriter().write("<h1>您好，欢迎您首次访问!</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
