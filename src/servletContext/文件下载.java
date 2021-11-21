package servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "servletContextDemo6", value = "/servletContextDemo6")
public class �ļ����� extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");           //��ȡ�������

        //ʹ���ֽ������������ļ����ڴ�
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/servletContext/" + filename);  //�ҵ��ļ��ķ�����·��
        FileInputStream fis = new FileInputStream(realPath);                    //ʹ���ֽ���������ȡ�ļ�

        //����response��Ӧͷ
        String mimeType = servletContext.getMimeType(filename);                   //��ȡmime����
        response.setHeader("content-type",mimeType);                              //������Ӧͷ����
        response.setHeader("content-disposition","attachment;filename=" + filename);    //������Ӧͷ�򿪷�ʽ

        //�����������¼�д��������¼�
        ServletOutputStream sos = response.getOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int length = 0;
        while((length = fis.read(buffer)) != -1){
            sos.write(buffer,0,length);
        }
        sos.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
