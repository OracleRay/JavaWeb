package proxy;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("����"+money+"����һ̨�������");
        return "�������";
    }

    @Override
    public void show() {
        System.out.println("չʾ����");
    }

}
