package com.lpan.java_summarize.config.scheduled;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpan.java_summarize.bootschedule.advance.ScheduleTask;
import com.lpan.java_summarize.common.schedulecron.model.CronScheduled;
import com.lpan.java_summarize.common.schedulecron.service.CronScheduledService;
import com.lpan.java_summarize.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/***
 * Spring 自带的 定时任务配置
 *
 *  spring自带的定时任务核心是 org.springframework.scheduling.config.ScheduledTaskRegistrar  类
 *  该类初始化完成后会执行 scheduleTasks() 此方法是根据基础任务执行所有已注册的任务
 *  最终所有task会保存在scheduledTasks 集合中
 *
 *  到目前为止  我们的定时任务 只能是通过提前提前添加好 服务启动的时候 从数据库查询出来放到scheduledTasks集合中 无法实现动态添加 修改 停止等操作
 *  下面我们就 可以通过动态的在scheduledTasks的结合进行操作即可实现动态添加，修改，停止等操作
 *
 *
 *
 *
 *
 *
 *
 */
//@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledConfig.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CronScheduledService cronScheduledService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        /**查出所有 任务表达式*/
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","1");
        List<CronScheduled> list = cronScheduledService.list(queryWrapper);
                for (CronScheduled cronScheduled:list){
                    try {
                        Class<?> clazz;
                        Object task;
                        clazz = Class.forName(cronScheduled.getTaskClass());
                        task = context.getBean(clazz);
                        Assert.isAssignable(ScheduleTask.class,clazz,"定时任务的类必须实现ScheduledTask接口");
                        scheduledTaskRegistrar.addTriggerTask(((Runnable) task),triggerContext -> {
                            //String cron_expression = cronScheduledService.getById(cronScheduled.getId()).getCronExpression();
                            String cron_expression = cronScheduled.getCronExpression();
                            Date date = new CronTrigger(cron_expression).nextExecutionTime(triggerContext);
                            return date;
                        });
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
    }

}
