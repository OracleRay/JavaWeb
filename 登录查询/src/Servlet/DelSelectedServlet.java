package Servlet;

import service.UserService;
import service.UserServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delSelectedServlet", value = "/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");

        UserService service = new UserServiceImplement();
        service.delSelectedUser(uids);

        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
