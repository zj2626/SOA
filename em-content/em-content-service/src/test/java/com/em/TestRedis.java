package com.em;

import common.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zj on 2017/7/23.
 */
public class TestRedis {

    @Test
    public void test(){
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        jedisClient.set("aaa", "bbb");
        System.out.println(jedisClient.get("aaa"));
    }
}
