package com.lpan.java_summarize.enums;

public enum ResultEnum {

    SUCCESS("0000","成功"),
    FAILD("9999","异常"),


    EXISTS("8999","该定时任务已存在"),




    CRONEXPRESSERROR("8899","Cron 表达式正确")
    ;

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
