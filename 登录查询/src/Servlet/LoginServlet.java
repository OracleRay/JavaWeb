package Servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.UserServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String verifycode = request.getParameter("verifycode");                 //获取用户输入验证码

        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");       //获取页面中的验证码
        session.removeAttribute("CHECKCODE_SERVER");                     //移除验证码，避免多次使用

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);            //将错误信息发送到jsp页面
            return;                   //返回登录页面
        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);                            //封装user对象为map集合
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImplement();                      //调用service查询user
        User loginUser = service.login(user);

        if(loginUser != null){
            session.setAttribute("user",loginUser);                       //登录成功，将user存入session
            response.sendRedirect(request.getContextPath()+"/index.jsp");           //跳转页面
        }
        else{
            request.setAttribute("login_msg","用户名或密码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
