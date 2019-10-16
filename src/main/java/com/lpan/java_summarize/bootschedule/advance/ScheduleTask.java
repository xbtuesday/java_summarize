package com.lpan.java_summarize.bootschedule.advance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.enums.StatusEnum;
import com.lpan.java_summarize.utils.SpringUtils;

public interface ScheduleTask extends Runnable {

    /**执行定时任务*/
    void executeTask();

    /**重写run方法*/
    @Override
    default void run(){
        CronScheduledService cronScheduledService = SpringUtils.getBean(CronScheduledService.class);
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper();
        queryWrapper.eq("cron_class",this.getClass().getName());
        CronScheduled cronScheduled = cronScheduledService.getOne(queryWrapper);
        String status = cronScheduled.getStatus();
        if (StatusEnum.DISABLED.getCode().equals(status)){
            return;
        }
        executeTask();
    }


}
