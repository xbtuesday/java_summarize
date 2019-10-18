package com.lpan.java_summarize.common.schedulecron.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("spring_cron_schedule")
public class CronScheduled {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String taskName;
    private String taskCode;
    private String taskClass;
    private String autoStartUp;
    private String cronExpression;
    private String taskMessage;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status;
}