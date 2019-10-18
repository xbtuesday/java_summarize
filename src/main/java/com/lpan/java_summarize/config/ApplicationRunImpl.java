package com.lpan.java_summarize.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRunImpl implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(ApplicationRunImpl.class);

    @Autowired
    CronScheduledService cronScheduledService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","1");
        queryWrapper.eq("auto_start_up","1");
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
        list.forEach(cronScheduled -> {
            try {
                logger.info("++++===========开始初始化定时任务:{}=============",cronScheduled.getTaskCode());
                cronScheduledService.startTask(cronScheduled);
                logger.info("++++===========结束初始化定时任务:{}=============",cronScheduled.getTaskCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
