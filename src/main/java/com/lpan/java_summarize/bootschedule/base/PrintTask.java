package com.lpan.java_summarize.bootschedule.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTask {

    private Logger logger = LoggerFactory.getLogger(PrintTask.class);

    private int count;

    @Scheduled(cron = "*/5 * * * * ?")
    public void exeute(){
        logger.info("===================第{}次执行定时任务======================{}",count++,Thread.currentThread().getName());
    }


}
