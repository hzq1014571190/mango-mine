package com.hzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author hzq
 * @ClassName MangoAdminApplication
 * @Date 2022/10/26 19:28
 * @Description
 */
@SpringBootApplication
@MapperScan("com.hzq.mapper")
public class MangoAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }
}
