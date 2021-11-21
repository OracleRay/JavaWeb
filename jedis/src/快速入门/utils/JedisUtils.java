package ��������.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

/**
 JedisPool������
 ���������ļ����������ӳصĲ���
 �ṩ��ȡ���ӵķ���
 */

public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        Properties properties = new Properties();
        try {
            properties.load(JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));

        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
