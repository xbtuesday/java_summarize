package com.lpan.java_summarize.common.schedulecron.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.domain.BaseResponse;

public interface CronScheduledService extends IService<CronScheduled> {
    /**创建查询条件*/
    QueryWrapper buildWrapper(CronScheduled cronScheduled);

    BaseResponse saveTask(CronScheduled cronScheduled) throws Exception;

    BaseResponse startTask(CronScheduled cronScheduled) throws Exception;

    BaseResponse reset(CronScheduled cronScheduled) throws Exception;

    BaseResponse stop(Integer id);
}
