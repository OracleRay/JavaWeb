package listener;

/**
 * ������
 *      ����������ServletContext (jsp application) ���������ڵġ�
 *      ��tomcat����ʱ ����contextInitialized���������ڴ���spring��������webApplicationContext��
 *      ��tomcat�ر�ʱ contextDestroyed �����������close�������رա�
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
        System.out.println("tomcat������");
        //������Դ�ļ�
        ServletContext servletContext = sce.getServletContext();           //��ȡservletContext����
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");//������Դ�ļ�
        //��ȡ�ļ���ʵ·��
        String realPath = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fis = new FileInputStream(realPath);               //�����ļ�����������Ŀ
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("tomcat�ر���");
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
