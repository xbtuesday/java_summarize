package com.lpan.java_summarize.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ExecutorConfig
 * Description: TODO  异步化执行事件的线程池配置
 *
 *      异步处理的线程池有两种方式  以注解方式的配置相对比较灵活
 *      如下：1、第一种方式   1、配置线程池 2、配置ApplicationEventMulticaster
 *           2、第二种方式   1、配置线程池 2、启动类上加 @EnableAsync  3、在需要异步执行的方法上加 @Async
 *
 * Author: lpan
 * Date 14/08/19 下午 03:07
 * Version: 1.0
 */
@Configuration
public class ExecutorConfig {

    @Bean("executors")
    public ExecutorService executors(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        return executorService;
    }

//    @Bean("applicationEventMulticaster")
//    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(@Qualifier("executors") ExecutorService executors){
//        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
//        simpleApplicationEventMulticaster.setTaskExecutor(executors);
//        return simpleApplicationEventMulticaster;
//    }



}
