package com.lpan.java_summarize.common.schedulecron.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.bootschedule.advance.ScheduleTask;
import com.lpan.java_summarize.bootschedule.dynamicscheduled.DynamicScheduledTask;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.config.scheduled.DynamicScheduledConfig;
import com.lpan.java_summarize.domain.BaseResponse;
import com.lpan.java_summarize.domain.BaseResult;
import com.lpan.java_summarize.enums.ParamEunm;
import com.lpan.java_summarize.enums.ResultEnum;
import com.lpan.java_summarize.utils.SpringUtils;
import com.lpan.java_summarize.utils.gson.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Controller
@RequestMapping("/cronschedule")
public class CronScheduledController {

    private final static Logger logger = LoggerFactory.getLogger(CronScheduledController.class);

    @Autowired
    CronScheduledService cronScheduledService;

    @Autowired
    DynamicScheduledConfig dynamicScheduledConfig;

    private ScheduledFuture<?> future;

    @PostMapping("/list")
    @ResponseBody
    public BaseResponse list(CronScheduled cronScheduled){
        QueryWrapper queryWrapper = cronScheduledService.buildWrapper(cronScheduled);
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
        String s = GsonUtil.GsonString(list);
        return BaseResult.success(s);
    }

    /***
     *  添加一个定时任务
     * @param cronScheduled
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public BaseResponse add(CronScheduled cronScheduled){
        Assert.notNull(cronScheduled, ParamEunm.NOTNULL.getMessage());
        BaseResponse baseResponse = new BaseResponse();
        try{
            baseResponse = cronScheduledService.saveTask(cronScheduled);
        }catch (Exception e){
            baseResponse.setCode(ResultEnum.FAILD.getCode());
            baseResponse.setCode(ResultEnum.FAILD.getMessage());
        }
        return baseResponse;
    }


    /***
     *  启动一个定时任务
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/start")
    public BaseResponse startTask(Integer id){
        Assert.notNull(id, ParamEunm.NOTNULL.getMessage());
        BaseResponse baseResponse = null;
        try{
            CronScheduled cronScheduled = cronScheduledService.getById(id);
            baseResponse = cronScheduledService.startTask(cronScheduled);
        }catch (Exception e){
           return BaseResult.result(ResultEnum.FAILD);
        }
        return baseResponse;
    }

    @ResponseBody
    @RequestMapping("/stop")
    public BaseResponse stop(Integer id){
        Assert.notNull(id, ParamEunm.NOTNULL.getMessage());
        BaseResponse stop = cronScheduledService.stop(id);
        return stop;
    }


    @PostMapping("/reset")
    @ResponseBody
    public BaseResponse reset(CronScheduled cronScheduled){
        Assert.notNull(cronScheduled, ParamEunm.NOTNULL.getMessage());
        Assert.notNull(cronScheduled.getId(), ParamEunm.NOTNULL.getMessage());
        BaseResponse baseResponse = null;
        try{
            baseResponse = cronScheduledService.reset(cronScheduled);
        }catch (Exception e){
            baseResponse.setCode(ResultEnum.FAILD.getCode());
            baseResponse.setCode(ResultEnum.FAILD.getMessage());
        }
        return baseResponse;
    }

    /**执行一次任务*/
    @PostMapping("/runtask")
    @ResponseBody
    public BaseResponse runTask(Integer id){
        Assert.notNull(id, ParamEunm.NOTNULL.getMessage());
        CronScheduled cronScheduled = cronScheduledService.getById(id);
        try{
            DynamicScheduledTask scheduleTask = (DynamicScheduledTask) SpringUtils.getBean(Class.forName(cronScheduled.getTaskClass()));
            scheduleTask.executDynmicTask();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return BaseResult.success(true);
    }

}
