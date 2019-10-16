package com.lpan.java_summarize.common.schedulecron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpan.java_summarize.common.schedulecron.mapper.CronScheduledMapper;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import org.springframework.stereotype.Service;

@Service
public class CronScheduledServiceImpl extends ServiceImpl<CronScheduledMapper, CronScheduled> implements CronScheduledService{
    @Override
    public QueryWrapper buildWrapper(CronScheduled cronScheduled) {
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper<>();
        if (null != cronScheduled){
            if (null != cronScheduled.getCronClass() && !"".equals(cronScheduled.getCronClass())){
                queryWrapper.eq("cron_class",cronScheduled.getCronClass());
            }
            if (null != cronScheduled.getCronExpression() && !"".equals(cronScheduled.getCronExpression())){
                queryWrapper.eq("cron_expression",cronScheduled.getCronExpression());
            }
            if (null != cronScheduled.getStatus() && !"".equals(cronScheduled.getStatus())){
                queryWrapper.eq("status",cronScheduled.getStatus());
            }
            if (null != cronScheduled.getId() && "".equals(cronScheduled.getId())){
                queryWrapper.eq("id",cronScheduled.getId());
            }

        }
        return queryWrapper;
    }
}
