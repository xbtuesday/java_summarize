package com.lpan.java_summarize.enums;

public enum StatusEnum {

    DISABLED("0","禁用"),
    ENABLED("1","启用")
    ;


    private String code;
    private String message;

    StatusEnum(String code, String message) {
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
