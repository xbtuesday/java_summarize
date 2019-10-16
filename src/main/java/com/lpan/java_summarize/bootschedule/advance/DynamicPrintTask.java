package com.lpan.java_summarize.bootschedule.advance;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class DynamicPrintTask implements ScheduleTask{

    Logger logger = LoggerFactory.getLogger(DynamicPrintTask.class);


    @Override
    public void executeTask() {
        logger.info("=-%$#@&*!(*&((!@^!%这是动态打印的日志*……%￥@！@#*（！……+"+ Thread.currentThread().getName());
    }

}
