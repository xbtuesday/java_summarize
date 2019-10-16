package com.lpan.java_summarize.common.schedulecron.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("spring_cron_schedule")
public class CronScheduled {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String cronClass;
    private String cronExpression;
    private String taskMessage;
    private String status = "0";
}
