package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();                 //创建真实对象
        /**
         三个参数：
         1. 类加载器：真实对象.getClass().getClassLoader()
         2. 接口数组：真实对象.getClass().getInterfaces()
         3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            /**
             代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             参数：
             1. proxy:代理对象
             2. method：代理对象调用的方法，被封装为的对象
             3. args:代理对象调用的方法时，传递的实际参数
             */
            //使用动态代理增强lenovo对象
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sale")){
                    double money = (double)args[0];
                    money = money * 0.85;
                    System.out.println("专车接你");
                    String obj = (String) method.invoke(lenovo, money);              //使用真实对象调用该方法
                    System.out.println("免费送货");
                    return obj + "鼠标垫";                             //增强返回值
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
