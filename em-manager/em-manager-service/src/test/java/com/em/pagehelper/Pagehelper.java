package com.em.pagehelper;

import com.em.mapper.TbItemMapper;
import com.em.pojo.TbItem;
import com.em.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zj on 2017/6/15.
 */
public class Pagehelper {

    @Test
    public void testPage() {
        //初始化Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        //获取代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);

        //执行sql语句前设置分页信息使用PageHelper的startPage方法
        PageHelper.startPage(1, 10);

        //查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);

        //取分页信息PageInfo 总记录数 总页数 当前页
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getEndRow());
        System.out.println(pageInfo.getFirstPage());
        System.out.println(pageInfo.getLastPage());
        System.out.println(pageInfo.getList());
        System.out.println(pageInfo.getNavigatePages());
        System.out.println(pageInfo.getNextPage());
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getPrePage());
        System.out.println(pageInfo.getSize());
        System.out.println(pageInfo.getStartRow());
    }
}
