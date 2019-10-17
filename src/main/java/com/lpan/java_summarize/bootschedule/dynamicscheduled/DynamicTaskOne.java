package com.lpan.java_summarize.bootschedule.dynamicscheduled;

import com.lpan.java_summarize.bootschedule.advance.DynamicPrintTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DynamicTaskOne implements DynamicScheduledTask {

    Logger logger = LoggerFactory.getLogger(DynamicPrintTask.class);

    @Override
    public void executDynmicTask() {
        logger.info("===============one============== currentThread:{}",Thread.currentThread().getName());
    }
}
