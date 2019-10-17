package com.lpan.java_summarize.common.schedulecron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpan.java_summarize.bootschedule.dynamicscheduled.DynamicScheduledTask;
import com.lpan.java_summarize.common.schedulecron.mapper.CronScheduledMapper;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.config.scheduled.DynamicScheduledConfig;
import com.lpan.java_summarize.domain.BaseResponse;
import com.lpan.java_summarize.domain.BaseResult;
import com.lpan.java_summarize.enums.ParamEunm;
import com.lpan.java_summarize.enums.ResultEnum;
import com.lpan.java_summarize.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.xml.transform.Result;

@Service
public class CronScheduledServiceImpl extends ServiceImpl<CronScheduledMapper, CronScheduled> implements CronScheduledService{

    private final static Logger logger = LoggerFactory.getLogger(CronScheduledServiceImpl.class);

    @Autowired
    DynamicScheduledConfig dynamicScheduledConfig;


    @Override
    public QueryWrapper buildWrapper(CronScheduled cronScheduled) {
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper<>();
        if (null != cronScheduled){
            if (null != cronScheduled.getTaskCode() && !"".equals(cronScheduled.getTaskCode())){
                queryWrapper.eq("task_code",cronScheduled.getTaskClass());
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


    public BaseResponse saveTask(CronScheduled cronScheduled) throws Exception {
        Assert.notNull(cronScheduled.getAutoStartUp(), ParamEunm.NOTNULL.getMessage());
        BaseResponse baseResponse = new BaseResponse();
        CronScheduled cronScheduled1 = new CronScheduled();
        cronScheduled1.setTaskCode(cronScheduled.getTaskCode());
        QueryWrapper queryWrapper = buildWrapper(cronScheduled1);
        Integer integer = baseMapper.selectCount(queryWrapper);
        if (integer >=1){
            baseResponse.setCode(ResultEnum.EXISTS.getCode());
            baseResponse.setMessage(ResultEnum.EXISTS.getMessage());
            return baseResponse;
        }
        baseMapper.insert(cronScheduled);
        if (cronScheduled.getAutoStartUp().equals(ParamEunm.AUTOSATRT.getCode())){
            baseResponse = startTask(cronScheduled);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse startTask(CronScheduled cronScheduled) throws Exception {
        boolean b = dynamicScheduledConfig.existsTask(cronScheduled.getTaskCode());
        if (b){
            throw new Exception("该任务已启动");
        }
        DynamicScheduledTask dynamicScheduledTask = (DynamicScheduledTask) SpringUtils.getBean(Class.forName(cronScheduled.getTaskClass()));
        boolean inited = dynamicScheduledConfig.inited();
        if (!inited){
            Thread.sleep(100);
        }
        dynamicScheduledConfig.addTask(cronScheduled.getTaskCode(),new TriggerTask(dynamicScheduledTask,new CronTrigger(cronScheduled.getCronExpression())));
        return BaseResult.success(true);
    }


    /***
     *  重置定时任务
     * @param cronScheduled
     * @return
     */
    @Override
    public BaseResponse reset(CronScheduled cronScheduled) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",cronScheduled.getId());
        baseMapper.update(cronScheduled,queryWrapper);
        if (cronScheduled.getAutoStartUp().equals(ParamEunm.AUTOSATRT.getCode())){
            baseResponse = this.startTask(cronScheduled);
        }else{
            baseResponse.setCode(ResultEnum.SUCCESS.getCode());
            baseResponse.setMessage(ResultEnum.SUCCESS.getMessage());
        }
        return baseResponse;
    }

    @Override
    public BaseResponse stop(Integer id) {
        QueryWrapper<CronScheduled> queryWrapper = new QueryWrapper<>();
        CronScheduled cronScheduled = baseMapper.selectById(id);
        cronScheduled.setStatus(ParamEunm.DISABLED.getCode());
        queryWrapper.eq("id",cronScheduled.getId());
        baseMapper.update(cronScheduled,queryWrapper);
        /**移除定时任务*/
        dynamicScheduledConfig.removeTask(cronScheduled.getTaskCode());
        return BaseResult.success(true);
    }
}
