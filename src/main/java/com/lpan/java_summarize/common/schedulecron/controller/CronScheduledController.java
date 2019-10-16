package com.lpan.java_summarize.common.schedulecron.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.bootschedule.advance.ScheduleTask;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.domain.BaseResponse;
import com.lpan.java_summarize.domain.BaseResult;
import com.lpan.java_summarize.enums.ParamEunm;
import com.lpan.java_summarize.utils.SpringUtils;
import com.lpan.java_summarize.utils.gson.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cronschedule")
public class CronScheduledController {

    @Autowired
    CronScheduledService cronScheduledService;

    @PostMapping("/list")
    @ResponseBody
    public BaseResponse list(CronScheduled cronScheduled){
        QueryWrapper queryWrapper = cronScheduledService.buildWrapper(cronScheduled);
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
        String s = GsonUtil.GsonString(list);
        return BaseResult.success(s);
    }

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse add(CronScheduled cronScheduled){
        Assert.notNull(cronScheduled, ParamEunm.NOTNULL.getMessage());
        boolean save = cronScheduledService.save(cronScheduled);
        return BaseResult.success(save);
    }


    @PostMapping("/update")
    @ResponseBody
    public BaseResponse update(CronScheduled cronScheduled){
        Assert.notNull(cronScheduled, ParamEunm.NOTNULL.getMessage());
        boolean save = cronScheduledService.saveOrUpdate(cronScheduled);
        return BaseResult.success(save);
    }

    /**执行一次任务*/
    @PostMapping("/runtask")
    @ResponseBody
    public BaseResponse runTask(@RequestParam("cronClass") String cronClass){
        Assert.notNull(cronClass, ParamEunm.NOTNULL.getMessage());
        try{
            ScheduleTask scheduleTask = (ScheduleTask) SpringUtils.getBean(Class.forName(cronClass));
            scheduleTask.executeTask();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return BaseResult.success(true);
    }

    @PostMapping("/enable")
    @ResponseBody
    public BaseResponse update(@RequestParam("status") String status,@RequestParam("id") Integer id) throws ClassNotFoundException {
        Assert.notNull(status, ParamEunm.NOTNULL.getMessage());
        Assert.notNull(id, ParamEunm.NOTNULL.getMessage());
        CronScheduled cronScheduled = new CronScheduled();
        cronScheduled.setId(id);
        cronScheduled.setStatus(status);
        boolean save = cronScheduledService.updateById(cronScheduled);
        ScheduleTask scheduleTask = (ScheduleTask) SpringUtils.getBean(Class.forName("com.lpan.java_summarize.bootschedule.advance.ScheduleTask"));
        scheduleTask.start(id);
        return BaseResult.success(save);
    }








}
