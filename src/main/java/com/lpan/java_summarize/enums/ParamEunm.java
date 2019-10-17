package com.lpan.java_summarize.enums;

public enum ParamEunm {

    NOTNULL("00","此参数不能为空"),
    AUTOSATRT("1","自动重启"),
    DISAUTOSTART("0","不自动重启"),
    ENABLE("1","可用状态"),
    DISABLED("0","不可用状态")
    ;


    private String code;
    private String message;

    ParamEunm(String code, String message) {
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
