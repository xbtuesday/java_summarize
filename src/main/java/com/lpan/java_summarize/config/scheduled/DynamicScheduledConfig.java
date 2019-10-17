package com.lpan.java_summarize.config.scheduled;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.bootschedule.advance.ScheduleTask;
import com.lpan.java_summarize.bootschedule.dynamicscheduled.DynamicScheduledTask;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.utils.BeanUtils;
import com.lpan.java_summarize.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Configuration
public class DynamicScheduledConfig implements SchedulingConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(DynamicScheduledConfig.class);

    @Autowired
    private CronScheduledService cronScheduledService;

    private ScheduledTaskRegistrar scheduledTaskRegistrar;

    private Set<ScheduledFuture<?>> scheduledFutureSet = null;

    private Map<String ,ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        this.scheduledTaskRegistrar = taskRegistrar;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","1");
        queryWrapper.eq("auto_start_up","1");
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
        list.forEach(cronScheduled -> {
            try {
                Class<?> clazz;
                Object task;
                clazz = Class.forName(cronScheduled.getTaskClass());
                task = SpringUtils.getBean(clazz);
                Assert.isAssignable(DynamicScheduledTask.class,clazz,"定时任务的类必须实现ScheduledTask接口");
                taskRegistrar.addTriggerTask(((Runnable) task),triggerContext -> {
                    String cron_expression = cronScheduled.getCronExpression();
                    Date date = new CronTrigger(cron_expression).nextExecutionTime(triggerContext);
                    return date;
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    /***
     * 动态的在定时任务的 Set<scheduledFuture>  集合中添加定时任务
     * 此方法是获取ScheduledTaskRegistrar 中的 Set<scheduledFuture>
     * @return
     */
    private Set<ScheduledFuture<?>> getScheduledFutureSet(){
        if (null == scheduledFutureSet){
            try{
                scheduledFutureSet = (Set<ScheduledFuture<?>>)BeanUtils.getProperty(scheduledTaskRegistrar,"scheduledTasks");
            }catch (NoSuchFieldException  e){
                logger.error("找不到类对应的属性：{}","scheduledTasks");
            }
        }
        return scheduledFutureSet;
    }

    public void intiTask(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","1");
        queryWrapper.eq("auto_start_up","1");
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);


    }

    /***
     *  添加定时任务
     * @param taskId
     * @param triggerTask
     */
    public void addTask(String taskId, TriggerTask triggerTask){
        if (scheduledFutureMap.containsKey(taskId)){
            throw new SchedulingException("{"+taskId+":  }定时任务已经存在");
        }
        TaskScheduler scheduler = scheduledTaskRegistrar.getScheduler();
        ScheduledFuture<?> scheduledFuture = scheduler.schedule(triggerTask.getRunnable(), triggerTask.getTrigger());
        getScheduledFutureSet().add(scheduledFuture);
        scheduledFutureMap.put(taskId,scheduledFuture);
    }


    /***
     *  移除 定时任务
     * @param taskId
     */
    public void removeTask(String taskId){
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(taskId);
        if (null != scheduledFuture){
            scheduledFuture.cancel(true);
        }
        scheduledFutureMap.remove(taskId);
        getScheduledFutureSet().remove(scheduledFuture);
    }

    /***
     *  重置定时任务
     * @param taskId
     * @param triggerTask
     */
    public void update(String taskId,TriggerTask triggerTask){
        removeTask(taskId);
        addTask(taskId,triggerTask);
    }

    /***
     *   是否存在定时任务
     * @param taskId
     * @return
     */
    public boolean existsTask(String taskId){
        boolean b = scheduledFutureMap.containsKey(taskId);
        return b;
    }

    /***
     * 判断定时任务是否初始化完成
     * @return
     */
    public boolean inited(){
        return scheduledTaskRegistrar != null && scheduledTaskRegistrar.getScheduledTasks() != null;
    }


}
