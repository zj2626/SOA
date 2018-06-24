# SOA

### 初次学习基于服务的分布式SOA系统的源码

####工具: IntelliJ IDEA

####创建时间: 2017-05-21

####涉及技术: spring, springmvc, mybatis, dubbo, zookeeper, redis, fastdfs

####学习视频及源码: 链接：https://pan.baidu.com/s/184E83JpZ5SxaR6TECXGimA 密码：w6ey

####启动:

>    1. 导入分别项目模块, 只需要导入其中三个模块即可, 其中manager中的子模块会自动导入

![](http://okow3aoov.bkt.clouddn.com/git_aos_1.png?imageView2/1/w/600/h/450)


>    2. 模块介绍:
```text
        1. SOA: 根模块, common,parent和manager继承了该模块, 此模块中配置了所有的依赖的版本信息(并非依赖本身)
        2. common:工具类模块,存放全局工具类
        3. manager: 后台模块父工程
        4. em-manager-web: 后台模块控制器
        5: parent: 前台模块父工程
        6: em-content: 前台模块业务层
        7: em-portal-web: 前台模块控制器
        8. generatorSqlmapCustom:  MyBatis逆向工程生成pojo的简单工具
```

        
![](http://okow3aoov.bkt.clouddn.com/git_aos_2.png?imageView2/1/w/600/h/450)
 
>   3. 查看Modules编译器配置是否正常 (正确的配置如图)

![](http://okow3aoov.bkt.clouddn.com/git_aos_3.png?imageView2/1/w/600/h/450)

>    4. 添加tomcat的maven插件,准备启动项目

![](http://okow3aoov.bkt.clouddn.com/git_aos_4.png?imageView2/1/w/600/h/450)


>    5. 启动项目, 可以默认的启动按钮(如果装有热部署插件,也可以), 如果出现下面的日志信息表示启动成功

![](http://okow3aoov.bkt.clouddn.com/git_aos_5.png?imageView2/1/w/600/h/450)

更新ing ...
