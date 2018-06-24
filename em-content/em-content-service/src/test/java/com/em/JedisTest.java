package com.em;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zj on 2017/7/14.
 */
public class JedisTest {

    //redis单机版可用
    @Test
    public void test() {
        //创建一个连接redis的Jedis对象
        Jedis jedis = null;

        try {
            jedis = new Jedis("127.0.0.1", 6379);
            jedis.auth("fangshuoit");//没有密码则不需要

            //使用Jedis操作redis
//        jedis.set("key_one", "my first test2");
            String value = jedis.get("key_one");
            System.out.println(value);
        } catch (JedisConnectionException e) {
            System.out.println("redis未配置或无法访问");
        } finally {
            //关闭连接
            if (jedis != null)
                jedis.close();
        }

    }

    //redis单机版可用
    @Test
    public void JedisPoolTest() {
        //创建连接池对象
        JedisPool jedisPool = null;
        //获取一个连接,即一个jedis
        Jedis jedis = null;

        try {
            jedisPool = new JedisPool("127.0.0.1", 6379);
            jedis = jedisPool.getResource();
            jedis.auth("fangshuoit");

            //操作
            String value = jedis.get("key_one");
            System.out.println(value);
        } catch (JedisConnectionException e) {
            System.out.println("redis未配置或无法访问");
        } finally {
            //关闭连接
            if (jedis != null)
                jedis.close();

            //关闭连接
            if (jedisPool != null)
                jedisPool.close();
        }
    }

    //redis集群可用
    @Test
    public void jedisClusterTest() {
        Set<HostAndPort> nodes = new HashSet();
        String host = "192.168.25.128";
        nodes.add(new HostAndPort(host, 7001));
        nodes.add(new HostAndPort(host, 7002));
        nodes.add(new HostAndPort(host, 7003));
        nodes.add(new HostAndPort(host, 7004));
        nodes.add(new HostAndPort(host, 7005));
        nodes.add(new HostAndPort(host, 7006));

        //创建一个JedisCluster对象
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = new JedisCluster(nodes);

            //使用JedisCluster操作redis
            jedisCluster.set("key_one", "my first test2");
            System.out.println(jedisCluster.get("key_one"));
        } catch (JedisConnectionException e) {
            System.out.println("redis集群未配置或无法访问");
        } finally {
            if (jedisCluster != null)
                jedisCluster.close();
        }
    }
}
