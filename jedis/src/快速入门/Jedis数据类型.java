package 快速入门;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedis数据类型 {

    /**
     * String类型操作
     */
    @Test
    public void Test1(){
        Jedis jedis = new Jedis("localhost",6379);              //获取连接,默认空参为localhost 6379
        jedis.set("username","zhangsan");                //操作
        String username = jedis.get("username");           //获取
        System.out.println(username);
        jedis.close();                       //关闭连接
        jedis.setex("activcode",20,"woqiao");           //设置一个20秒以后自动删除的key
    }
    /**
     * hash数据结构操作
     */
    @Test
    public void Test2(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","gender","男");
        jedis.hset("user","age","23");

        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
        jedis.close();
    }
    /**
     * list数据结构操作
     */
    @Test
    public void Test3(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);    //范围获取
        System.out.println(mylist);                     //[c, b, a, a, b, c]

        String mylist1 = jedis.lpop("mylist");
        System.out.println(mylist1);                      //c

        String mylist2 = jedis.rpop("mylist");
        System.out.println(mylist2);                     //c
        jedis.close();
    }
    /**
     * set数据结构操作
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
     * sortedset数据结构操作
     */
    @Test
    public void Test5(){
        Jedis jedis = new Jedis();
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"后裔");
        jedis.zadd("mysortedset",55,"孙悟空");

        // sortedset 获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset);             //[亚瑟, 后裔, 孙悟空]
        jedis.close();
    }
}

