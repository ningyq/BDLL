package com.xuptdata.bdll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xuptdata.bdll.mapper")
public class BdllApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdllApplication.class, args);
    }

}
