package com.ccsu.jobcollection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.ccsu.jobcollection.*"})
@MapperScan("com.ccsu.jobcollection.mapper")
public class JobcollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobcollectionApplication.class, args);
    }

}
