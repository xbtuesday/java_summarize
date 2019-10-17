package com.lpan.java_summarize.common.schedulecron.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("spring_schedule_result")
public class ScheduleResult {

    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String taskName;
    private String taskCode;
    private String result;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String detailMessage;
    private String status;
}
