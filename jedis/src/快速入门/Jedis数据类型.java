package ��������;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedis�������� {

    /**
     * String���Ͳ���
     */
    @Test
    public void Test1(){
        Jedis jedis = new Jedis("localhost",6379);              //��ȡ����,Ĭ�Ͽղ�Ϊlocalhost 6379
        jedis.set("username","zhangsan");                //����
        String username = jedis.get("username");           //��ȡ
        System.out.println(username);
        jedis.close();                       //�ر�����
        jedis.setex("activcode",20,"woqiao");           //����һ��20���Ժ��Զ�ɾ����key
    }
    /**
     * hash���ݽṹ����
     */
    @Test
    public void Test2(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","gender","��");
        jedis.hset("user","age","23");

        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
        jedis.close();
    }
    /**
     * list���ݽṹ����
     */
    @Test
    public void Test3(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);    //��Χ��ȡ
        System.out.println(mylist);                     //[c, b, a, a, b, c]

        String mylist1 = jedis.lpop("mylist");
        System.out.println(mylist1);                      //c

        String mylist2 = jedis.rpop("mylist");
        System.out.println(mylist2);                     //c
        jedis.close();
    }
    /**
     * set���ݽṹ����
     */
    @Test
    public void Test4(){
        Jedis jedis = new Jedis();
        jedis.sadd("myset","apple","banana","cat");

        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);             //[banana, apple, cat]
        jedis.close();
    }
    /**
     * sortedset���ݽṹ����
     */
    @Test
    public void Test5(){
        Jedis jedis = new Jedis();
        jedis.zadd("mysortedset",3,"��ɪ");
        jedis.zadd("mysortedset",30,"����");
        jedis.zadd("mysortedset",55,"�����");

        // sortedset ��ȡ
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset);             //[��ɪ, ����, �����]
        jedis.close();
    }
}

