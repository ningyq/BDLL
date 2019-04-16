package com.xuptdata.bdll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuptdata.bdll.mapper")
public class BdllApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdllApplication.class, args);
    }

}
