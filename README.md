# SOA

### 初次学习基于服务的分布式SOA系统的源码

####工具: IntelliJ IDEA

####最初时间: 2017-05-21

####涉及技术: spring, springmvc, mybatis ...

####启动:
    1. 导入分别项目模块, 只需要导入其中三个模块即可, 其中manager中的子模块会自动导入
        ![](http://okow3aoov.bkt.clouddn.com/git_aos_1.png)

    2. 模块介绍:
        1.SOA: 根模块, common和manager继承了该模块, 此模块中配置了所有的依赖的版本信息(并非依赖本身)
        2.common:工具类模块,存放全局工具类
        3.manager: 项目模块
            3.1: dao: 持久层,直接操作数据库
            3.2: interface: service接口层
            3.3: pojo: 持久化类,与数据库中表一一对应
            3.4: service: 业务操作层, 实现接口
            3.5: web: 控制层, 书写controller
        4.generatorSqlmapCustom:  MyBatis逆向工程生成pojo的简单工具
        ![](http://okow3aoov.bkt.clouddn.com/git_aos_2.png)
    3. 查看Modules编译器配置是否正常 (正确的配置如图)
        ![](http://okow3aoov.bkt.clouddn.com/git_aos_3.png)
    4. 添加tomcat的maven插件,准备启动项目
        ![](http://okow3aoov.bkt.clouddn.com/git_aos_4.png)
    5. 启动项目, 可以默认的启动按钮(如果装有热部署插件,也可以), 如果出现下面的日志信息表示启动成功
        ![](http://okow3aoov.bkt.clouddn.com/git_aos_5.png)
