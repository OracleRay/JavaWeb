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
        //�����reqǿתΪHttpservletReques����getRequestURI����
        HttpServletRequest request = (HttpServletRequest)req;

        String uri = request.getRequestURI();
        if(uri.contains("login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            chain.doFilter(req, response);                  //�û����ʵľ��ǵ�¼���棬����
        }else {
            Object user = request.getSession().getAttribute("user");               //��ȡsession�е�user
            if(user != null){
                chain.doFilter(req, response);              //�û��Ѿ���¼������
            }else{
                request.setAttribute("login_msg","����δ��¼");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }

    }
}
