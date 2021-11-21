package listener;

/**
 * 监听器
 *      是用来监听ServletContext (jsp application) 的生命周期的。
 *      当tomcat启动时 调用contextInitialized方法，用于创建spring的容器（webApplicationContext）
 *      当tomcat关闭时 contextDestroyed 调用容器里的close方法，关闭。
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ListenerDemo implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public ListenerDemo() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("tomcat启动了");
        //加载资源文件
        ServletContext servletContext = sce.getServletContext();           //获取servletContext对象
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");//加载资源文件
        //获取文件真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fis = new FileInputStream(realPath);               //加载文件进入整个项目
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("tomcat关闭了");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
