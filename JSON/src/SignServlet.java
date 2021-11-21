import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "signServlet", value = "/signServlet")
public class SignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        response.setContentType("application/json;charset=utf-8");

        Map<String,Object> map = new HashMap<>();

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user where name = ?";
        List list = template.queryForList(sql, username);

        if(CollectionUtils.isEmpty(list)){
            map.put("userExist",false);
            map.put("msg","这个可以");
        }else{
            map.put("userExist",true);
            map.put("msg","哒唛");
        }

/*        if("tom".equals(username)){
            map.put("userExist",true);
            map.put("msg","换一发");
        }else{
            map.put("userExist",false);
            map.put("msg","这个可以");
        }*/

        ObjectMapper om = new ObjectMapper();
        om.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
