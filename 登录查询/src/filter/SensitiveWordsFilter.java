package filter;

/**
 * ���ɣ��޷���getParameterMap()�����������дʻ����
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter(value = "/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list1 = new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {
        //��ȡ�ļ���ʵ·��
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/���дʻ�.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(realPath));         //���ļ����ؽ���������ȡ
            String line = null;
            while ((line = br.readLine()) != null){
                list1.add(line);
            }
            br.close();
            System.out.println(list1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //�����������
        ServletRequest proxy_requset = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            //��ǿgetParameter����
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(request, args);               //��ǿ����ֵ
                    if (value != null) {
                        for (String str : list1) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "**");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });
        chain.doFilter(proxy_requset, response);                          //����
    }

}
