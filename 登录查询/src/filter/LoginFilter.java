package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //必须把req强转为HttpservletReques才有getRequestURI方法
        HttpServletRequest request = (HttpServletRequest)req;

        String uri = request.getRequestURI();
        if(uri.contains("login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            chain.doFilter(req, response);                  //用户访问的就是登录界面，放行
        }else {
            Object user = request.getSession().getAttribute("user");               //获取session中的user
            if(user != null){
                chain.doFilter(req, response);              //用户已经登录，放行
            }else{
                request.setAttribute("login_msg","您尚未登录");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }

    }
}
