package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseServletDemo3", value = "/responseServletDemo3")
public class 输出字符流 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");         //设置流的默认编码
//        response.setHeader("content-type","text/html;utf-8");         //设置浏览器响应头信息中的默认编码
        response.setContentType("text/html;charset=utf-8");              //简单的形式去设置浏览器编码
        PrintWriter pw = response.getWriter();
        pw.write("<h1>你好吗，response？</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
