package com.lpan.java_summarize.config.scheduled;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@Configuration
public class AsyncConfig {

    private int corePoolSize = 10;
    private int maxPoolSize = 20;
    private int queueCapacity = 10;

    @Bean
    public Executor taskExecutor(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(corePoolSize);

//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
//        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
//        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
//        threadPoolTaskExecutor.initialize();
        return scheduledExecutorService;
    }



}
