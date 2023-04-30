package com.kina.boot.config;

import com.kina.boot.bean.Pet;
import com.kina.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1.配置类里面使用@bean标注在方法上给容器注册组件，默认也是单例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理bean方法
 * full(proxyBeanMethods = true)全配置、Lite(proxyBeanMethods = false)轻量级配置，解决组件依赖问题
 */
@Configuration // 告诉springboot这是一个配置类 与起以前的配置文件类似
public class MyConfig {
    /**
     * 外部无论对配置类中的这个组件方法调用多少此获取的都是之前注册容器中的单实例对象
     * 如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中有，如果有，就不会创建对象，总会保持单实例。
     * @return
     */
    @Bean // 给容器中添加组件。以方法名作为组件的id，返回类型就是组件类型。返回值就是组件在容器中保存的实例。
    public User user01(){
        return new User("zhangsan", 18);
    }

    @Bean
    public Pet tomcatPet() {
        return new Pet("cat");
    }
}
