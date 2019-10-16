package com.lpan.java_summarize.enums;

public enum ParamEunm {

    NOTNULL("00","此参数不能为空")
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
