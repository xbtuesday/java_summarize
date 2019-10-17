package com.lpan.java_summarize.bootschedule.advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddTask implements ScheduleTask {

    Logger logger = LoggerFactory.getLogger(DynamicPrintTask.class);

    @Override
    public void executeTask() {
        logger.info("#######################add================="+ Thread.currentThread().getName());
    }
}
