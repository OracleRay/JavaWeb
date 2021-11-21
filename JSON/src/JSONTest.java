import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

//将Java对象转换为JSON

public class JSONTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());
        /*
            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串
         */
        ObjectMapper mapper = new ObjectMapper();               //创建jackon的核心对象
        try {
            String json = mapper.writeValueAsString(p);
            //mapper.writeValue(new File("e:\\json.txt"),p);             //将json创建到本地
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    /**
     *复杂java对象转换
     *    1. List：数组
     *    2. Map：对象格式一致
     */
    public void test1() throws Exception{
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(18);
        p2.setGender("男");
        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(18);
        p3.setGender("男");

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
        map.put("name","张三");
        map.put("age",18);
        map.put("gender","男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        System.out.println(json);
    }
    //Json转换为Java对象
    @Test
    public void test3() throws Exception{
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":18}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

}
