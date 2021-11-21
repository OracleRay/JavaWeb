package filter;

/**
 * 存疑：无法对getParameterMap()方法进行敏感词汇过滤
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
        //获取文件真实路径
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(realPath));         //将文件加载进缓存区读取
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
        //创建代理对象
        ServletRequest proxy_requset = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            //增强getParameter对象
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(request, args);               //增强返回值
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
        chain.doFilter(proxy_requset, response);                          //放行
    }

}
