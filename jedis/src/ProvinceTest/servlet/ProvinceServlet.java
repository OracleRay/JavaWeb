package ProvinceTest.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ProvinceTest.domain.Province;
import ProvinceTest.service.ProvinceService;
import ProvinceTest.service.ProvinceServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "provinceServlet", value = "/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 调用数据库的方法
         */
        /*ProvinceService service = new ProvinceServiceImplement();
        List<Province> provinces = service.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(provinces);//将查询到的数据封装为json*/
        /**
         * 调用redis缓存的方法，若没有，则从数据库调取
         */
        ProvinceService service = new ProvinceServiceImplement();
        String json = service.findJson();

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
