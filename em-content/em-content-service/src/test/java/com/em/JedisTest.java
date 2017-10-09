package com.em;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

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
        Jedis jedis = new Jedis("115.159.40.33", 6379);
        jedis.auth("fangshuoit");//没有密码则不需要

        //使用Jedis操作redis
//        jedis.set("key_one", "my first test2");
        String value = jedis.get("key_one");
        System.out.println(value);

        //关闭连接
        jedis.close();
    }

    //redis单机版可用
    @Test
    public void JedisPoolTest() {
        //创建连接池对象
        JedisPool jedisPool = new JedisPool("115.159.40.33", 6379);

        //获取一个连接,即一个jedis
        Jedis jedis = jedisPool.getResource();
        jedis.auth("fangshuoit");

        //操作
        String value = jedis.get("key_one");
        System.out.println(value);

        //关闭连接
        jedis.close();

        //关闭连接池
        jedisPool.close();
    }

    //redis集群可用
    @Test
    public void jedisClusterTest() {
        //创建一个JedisCluster对象
        Set<HostAndPort> nodes = new HashSet();
        nodes.add(new HostAndPort("115.159.40.33", 7001));
        nodes.add(new HostAndPort("115.159.40.33", 7002));
        nodes.add(new HostAndPort("115.159.40.33", 7003));
        nodes.add(new HostAndPort("115.159.40.33", 7004));
        nodes.add(new HostAndPort("115.159.40.33", 7005));
        nodes.add(new HostAndPort("115.159.40.33", 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);

        //使用JedisCluster操作redis
        jedisCluster.set("key_one", "my first test2");
        System.out.println(jedisCluster.get("key_one"));

        jedisCluster.close();
    }
}
