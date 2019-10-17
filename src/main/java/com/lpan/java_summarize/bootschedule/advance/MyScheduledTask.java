package com.lpan.java_summarize.bootschedule.advance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyScheduledTask extends Thread {

    @Autowired
    CronScheduledService cronScheduledService;

    @Override
    public void run() {
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper();
        queryWrapper.eq("cron_class",this.getClass().getName());
        CronScheduled cronScheduled = cronScheduledService.getOne(queryWrapper);
        String status = cronScheduled.getStatus();
        if (StatusEnum.DISABLED.getCode().equals(status)){
            return;
        }
        executeTask();
    }

    public abstract void executeTask();


}
