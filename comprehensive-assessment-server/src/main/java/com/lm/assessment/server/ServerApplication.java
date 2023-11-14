package com.lm.assessment.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Description 启动类
 * @Date 2023/1/20
 */
@SpringBootApplication()
@ComponentScan(basePackages = {"com.lm"})
@MapperScan("com.lm.assessment.server.mapper")
public class ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServerApplication.class, args);
        Arrays.stream(run.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("11");
    }


}
