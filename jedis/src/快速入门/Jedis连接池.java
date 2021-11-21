package 快速入门;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import 快速入门.utils.JedisUtils;

public class Jedis连接池 {
    @Test
    public void Test(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);            //最大允许连接数
        config.setMaxIdle(10);           //最大空闲连接数

        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        Jedis jedis = jedisPool.getResource();
        jedis.set("hello","wocao");
        System.out.println(jedis.get("hello"));
        jedis.close();
    }
    @Test
    public void TestPool(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("hello","redisPool");
        jedis.close();
    }
}
