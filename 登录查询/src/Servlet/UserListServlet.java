package Servlet;

import domain.User;
import service.UserServiceImplement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userListServlet", value = "/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImplement service = new UserServiceImplement();            //1.����UserService��ɲ�ѯ
        List<User> users = service.findAll();

        request.setCharacterEncoding("utf-8");
        request.setAttribute("users",users);                   //2.��users����request��
        request.getRequestDispatcher("/list.jsp").forward(request,response);           //3.ת����list.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
