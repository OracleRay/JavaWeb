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
public class �ϴη���ʱ�� extends HttpServlet {
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
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");     //��ȡ�й�ʱ��
                    String last_Time = sdf.format(date);

                    last_Time = URLEncoder.encode(last_Time, "utf-8");      //��cookieֵ����url���룬ʹ������пո�����

                    cookie.setValue(last_Time);                     //����cookieֵ
                    cookie.setMaxAge(60*60*24*30);               //����cookie���ʱ��Ϊһ����
                    response.addCookie(cookie);                       //����cookie

                    String value = cookie.getValue();                 //��ȡcookieֵ

                    value = URLDecoder.decode(value, "utf-8");            //��cookieֵ���н���

                    response.getWriter().write("<h1>��ӭ���������ϴη���ʱ��Ϊ��" + value + "</h1>");
                    break;
                }
            }
        }
        if(cookies == null || cookies.length == 0 || flag == false){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");     //��ȡ�й�ʱ��
            String last_Time = sdf.format(date);

            last_Time = URLEncoder.encode(last_Time, "utf-8");      //��cookieֵ����url���룬ʹ������пո�����

            Cookie cookie = new Cookie("lastTime",last_Time);
            cookie.setMaxAge(60*60*24*30);               //����cookie���ʱ��Ϊһ����
            response.addCookie(cookie);                       //����cookie

            response.getWriter().write("<h1>���ã���ӭ���״η���!</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
