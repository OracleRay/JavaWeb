package Filter;

/**
 * * 拦截路径配置：
 *             1. 具体资源路径： /index.jsp       只有访问index.jsp资源时，过滤器才会被执行
 *             2. 拦截目录： /user/*             访问/user下的所有资源时，过滤器都会被执行
 *             3. 后缀名拦截： *.jsp              访问所有后缀名为jsp资源时，过滤器都会被执行
 *             4. 拦截所有资源：/*                访问所有资源时，过滤器都会被执行
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//用户单独访问  index.jsp  会被过滤器拦截到，只有服务器转发时才会访问
@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器被执行了！！！");
        chain.doFilter(request, response);               //放行
    }
}
