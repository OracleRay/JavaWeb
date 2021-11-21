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
         * �������ݿ�ķ���
         */
        /*ProvinceService service = new ProvinceServiceImplement();
        List<Province> provinces = service.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(provinces);//����ѯ�������ݷ�װΪjson*/
        /**
         * ����redis����ķ�������û�У�������ݿ��ȡ
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
