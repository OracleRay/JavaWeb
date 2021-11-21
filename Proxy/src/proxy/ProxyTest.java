package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();                 //������ʵ����
        /**
         ����������
         1. �����������ʵ����.getClass().getClassLoader()
         2. �ӿ����飺��ʵ����.getClass().getInterfaces()
         3. ��������new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            /**
             �����߼���д�ķ��������������õ����з������ᴥ���÷���ִ��
             ������
             1. proxy:�������
             2. method�����������õķ���������װΪ�Ķ���
             3. args:���������õķ���ʱ�����ݵ�ʵ�ʲ���
             */
            //ʹ�ö�̬������ǿlenovo����
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sale")){
                    double money = (double)args[0];
                    money = money * 0.85;
                    System.out.println("ר������");
                    String obj = (String) method.invoke(lenovo, money);              //ʹ����ʵ������ø÷���
                    System.out.println("����ͻ�");
                    return obj + "����";                             //��ǿ����ֵ
                }else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });
        proxy_lenovo.show();
        proxy_lenovo.sale(8000);
    }
}
