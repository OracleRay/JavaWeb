package Filter;
/**���ö��������
 * ע�����ã������������ַ����ȽϹ���Ƚϣ�ֵС����ִ��
 *                 * �磺 AFilter �� BFilter��AFilter����ִ���ˡ�
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
        System.out.println("1��ִ����");
        chain.doFilter(request, response);
        System.out.println("1������");
    }
}
