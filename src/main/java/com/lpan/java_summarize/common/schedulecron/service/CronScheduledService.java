package com.lpan.java_summarize.common.schedulecron.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;

public interface CronScheduledService extends IService<CronScheduled> {
    /**创建查询条件*/
    QueryWrapper buildWrapper(CronScheduled cronScheduled);
}
