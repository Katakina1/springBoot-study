package com.kina.boot;

import com.kina.boot.bean.User;
import com.kina.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootAppllication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    // 主程序类
    public static void main(String[] args) {
        // 1.返回我们的Ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 2，查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name :
                names) {
            System.out.println(name);
        }

        // 3.从容器中获取组件  组件默认就是单例模式的
        User user = run.getBean("user01", User.class);
        System.out.println(user);
        User user1 = run.getBean("user01", User.class);
        System.out.println(user == user1);

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        User user2 = bean.user01();
        System.out.println(user == user2);
    }
}
