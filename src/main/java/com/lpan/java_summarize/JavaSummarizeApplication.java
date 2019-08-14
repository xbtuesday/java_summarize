package com.lpan.java_summarize;

import com.lpan.java_summarize.designpattern.springobserver.event.MyServiceEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaSummarizeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JavaSummarizeApplication.class, args);
        applicationContext.publishEvent(new MyServiceEvent("发布事件"));
    }

}
