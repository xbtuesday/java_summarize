package com.lpan.java_summarize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JavaSummarizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSummarizeApplication.class, args);
    }

}
