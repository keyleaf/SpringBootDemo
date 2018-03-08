package com.banana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by TJ on 18/3/7.
 */
//如果添加了数据库组件（mybatis）却没有配置相应的数据源，autoconfig在读取数据源配置时读取不到
// 需要增加 exclude = {DataSourceAutoConfiguration.class} 否则会导致异常出现。
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
