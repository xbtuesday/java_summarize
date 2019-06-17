package com.lpan.java_summarize.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:
 * @author: shipan
 * @Date: 2019/6/17 21:07
 * @ClassName: MyJob
 * @Version 1.0
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("---------job start---------");
    }
}
