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
        String verifycode = request.getParameter("verifycode");                 //��ȡ�û�������֤��

        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");       //��ȡҳ���е���֤��
        session.removeAttribute("CHECKCODE_SERVER");                     //�Ƴ���֤�룬������ʹ��

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","��֤�����");
            request.getRequestDispatcher("/login.jsp").forward(request,response);            //��������Ϣ���͵�jspҳ��
            return;                   //���ص�¼ҳ��
        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);                            //��װuser����Ϊmap����
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImplement();                      //����service��ѯuser
        User loginUser = service.login(user);

        if(loginUser != null){
            session.setAttribute("user",loginUser);                       //��¼�ɹ�����user����session
            response.sendRedirect(request.getContextPath()+"/index.jsp");           //��תҳ��
        }
        else{
            request.setAttribute("login_msg","�û������������!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
