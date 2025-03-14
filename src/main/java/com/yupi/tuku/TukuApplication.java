package com.yupi.tuku;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yupi.tuku.mapper")
@EnableAspectJAutoProxy(exposeProxy=true)
public class TukuApplication {

    public static void main(String[] args) {
        SpringApplication.run(TukuApplication.class, args);
    }

}
