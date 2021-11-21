package ��������;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import ��������.utils.JedisUtils;

public class Jedis���ӳ� {
    @Test
    public void Test(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);            //�������������
        config.setMaxIdle(10);           //������������

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
