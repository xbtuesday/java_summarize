package com.lpan.java_summarize.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.bootschedule.advance.MyScheduledTask;
import com.lpan.java_summarize.bootschedule.advance.ScheduleTask;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledConfig.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CronScheduledService cronScheduledService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        /**查出所有 任务表达式*/
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","1");
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
                for (CronScheduled cronScheduled:list){
                    try {
                        Class<?> clazz;
                        Object task;
                        clazz = Class.forName(cronScheduled.getCronClass());
                        task = context.getBean(clazz);
                        Assert.isAssignable(ScheduleTask.class,clazz,"定时任务的类必须实现ScheduledTask接口");
                        scheduledTaskRegistrar.addTriggerTask(((Runnable) task),triggerContext -> {
                            //String cron_expression = cronScheduledService.getById(cronScheduled.getId()).getCronExpression();
                            String cron_expression = cronScheduled.getCronExpression();
                            Date date = new CronTrigger(cron_expression).nextExecutionTime(triggerContext);
                            return date;
                        });
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
    }

//    @Bean
//    public Executor taskExecutor(){
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        return scheduledExecutorService;
//    }
}
