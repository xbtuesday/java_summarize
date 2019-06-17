package com.lpan.java_summarize.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description:
 * @author: shipan
 * @Date: 2019/6/17 21:02
 * @ClassName: MySchedule
 * @Version 1.0
 */
public class MySchedule {

    public static void  mytestschedule(){
        try {
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler scheduler = schedFact.getScheduler();
            scheduler.start();

            JobDetail job = newJob(MyJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger trigger = newTrigger().withIdentity("myJob", "group1").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(4)
                    .repeatForever()).build();

            scheduler.scheduleJob(job,trigger);


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        mytestschedule();
    }

}
