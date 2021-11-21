package Filter;
/**配置多个过滤器
 * 注解配置：按照类名的字符串比较规则比较，值小的先执行
 *                 * 如： AFilter 和 BFilter，AFilter就先执行了。
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(value = "/index.jsp")
public class FilterDemo1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("1被执行了");
        chain.doFilter(request, response);
        System.out.println("1回来了");
    }
}
