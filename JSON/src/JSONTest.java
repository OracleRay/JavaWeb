import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

//��Java����ת��ΪJSON

public class JSONTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("����");
        p.setAge(18);
        p.setGender("��");
        p.setBirthday(new Date());
        /*
            ת��������
                writeValue(����1��obj):
                    ����1��
                        File����obj����ת��ΪJSON�ַ����������浽ָ�����ļ���
                        Writer����obj����ת��ΪJSON�ַ���������json������䵽�ַ��������
                        OutputStream����obj����ת��ΪJSON�ַ���������json������䵽�ֽ��������
                writeValueAsString(obj):������תΪjson�ַ���
         */
        ObjectMapper mapper = new ObjectMapper();               //����jackon�ĺ��Ķ���
        try {
            String json = mapper.writeValueAsString(p);
            //mapper.writeValue(new File("e:\\json.txt"),p);             //��json����������
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    /**
     *����java����ת��
     *    1. List������
     *    2. Map�������ʽһ��
     */
    public void test1() throws Exception{
        Person p1 = new Person();
        p1.setName("����");
        p1.setAge(18);
        p1.setGender("��");
        Person p2 = new Person();
        p2.setName("����");
        p2.setAge(18);
        p2.setGender("��");
        Person p3 = new Person();
        p3.setName("����");
        p3.setAge(18);
        p3.setGender("��");

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personList);

        System.out.println(json);
    }
    @Test
    public void test2() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("name","����");
        map.put("age",18);
        map.put("gender","��");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        System.out.println(json);
    }
    //Jsonת��ΪJava����
    @Test
    public void test3() throws Exception{
        String json = "{\"gender\":\"��\",\"name\":\"����\",\"age\":18}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

}
