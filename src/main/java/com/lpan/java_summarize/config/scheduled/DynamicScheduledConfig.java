package com.lpan.java_summarize.config.scheduled;


import com.lpan.java_summarize.utils.BeanUtils;
import io.netty.util.internal.ConcurrentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Configuration
public class DynamicScheduledConfig implements SchedulingConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(DynamicScheduledConfig.class);

    private ScheduledTaskRegistrar scheduledTaskRegistrar;

    private Set<ScheduledFuture<?>> scheduledFutureSet = new ConcurrentSet<>();

    private Map<String ,ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        this.scheduledTaskRegistrar = taskRegistrar;
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
            }catch (NoSuchFieldException e){
                logger.error("找不到类对应的属性：{}","scheduledTasks");
            }
        }
        return scheduledFutureSet;
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
        this.getScheduledFutureSet().add(scheduledFuture);
        scheduledFutureMap.put(taskId,scheduledFuture);
    }

    /***
     *  移除 定时任务
     * @param taskId
     */
    public void removeTask(String taskId){
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(taskId);
        if (null != scheduledFuture && !scheduledFuture.isCancelled()){
            scheduledFuture.cancel(true);
            scheduledFuture.cancel(true);
        }
        scheduledFutureSet.remove(scheduledFuture);
        scheduledFutureMap.remove(taskId);
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
