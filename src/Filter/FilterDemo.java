package Filter;

/**
 * * ����·�����ã�
 *             1. ������Դ·���� /index.jsp       ֻ�з���index.jsp��Դʱ���������Żᱻִ��
 *             2. ����Ŀ¼�� /user/*             ����/user�µ�������Դʱ�����������ᱻִ��
 *             3. ��׺�����أ� *.jsp              �������к�׺��Ϊjsp��Դʱ�����������ᱻִ��
 *             4. ����������Դ��/*                ����������Դʱ�����������ᱻִ��
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//�û���������  index.jsp  �ᱻ���������ص���ֻ�з�����ת��ʱ�Ż����
@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("��������ִ���ˣ�����");
        chain.doFilter(request, response);               //����
    }
}
