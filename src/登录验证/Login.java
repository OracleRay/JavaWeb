package ��¼��֤;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.����request����
        request.setCharacterEncoding("utf-8");
        //2.��ȡ����
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //3.�Ȼ�ȡ���ɵ���֤��
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //ɾ��session�д洢����֤��
        session.removeAttribute("checkCode_session");

        User userLogin = new User();                      //�û������user
        userLogin.setUsername(username);
        userLogin.setPassword(password);

        UserLogin login = new UserLogin();               //����UserLogin����
        User user = login.login(userLogin);

        //3.���ж���֤���Ƿ���ȷ
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //���Դ�Сд�Ƚ�
            //��֤����ȷ
            //�ж��û����������Ƿ�һ��
            if(user != null){//��Ҫ����UserDao��ѯ���ݿ�
                //��¼�ɹ�
                //�洢��Ϣ���û���Ϣ
                session.setAttribute("user",username);
                //�ض���success.jsp
                response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp");
            }else{
                //��¼ʧ��
                //�洢��ʾ��Ϣ��request
                request.setAttribute("login_error","�û������������");
                //ת������¼ҳ��
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //��֤�벻һ��
            //�洢��ʾ��Ϣ��request
            request.setAttribute("cc_error","��֤�����");
            //ת������¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
