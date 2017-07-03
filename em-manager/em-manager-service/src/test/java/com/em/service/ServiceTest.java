package com.em.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zj on 2017/7/2.
 */
public class ServiceTest {

    //发布服务到dubbo的测试工具
    @Test
    public void publishService() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        System.out.println("服务已启动 输入任意内容停止");
//        System.in.read();  //idea进行 mvn install的时候会卡在这里
        System.out.println("服务已停止");
    }
}
