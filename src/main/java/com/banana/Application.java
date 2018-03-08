package com.banana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

/**
 * Created by TJ on 18/3/7.
 *
 * https://spring.io/guides/gs/spring-boot/
 * https://github.com/keyleaf/SpringBootDemo
 */
//如果添加了数据库组件（mybatis）却没有配置相应的数据源，autoconfig在读取数据源配置时读取不到
// 需要增加 exclude = {DataSourceAutoConfiguration.class} 否则会导致异常出现。
@EnableAutoConfiguration
@SpringBootApplication
//配置扫描Mapper接口
@MapperScan(basePackages = "com.banana.mapper")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
