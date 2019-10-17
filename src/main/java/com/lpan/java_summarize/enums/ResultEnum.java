package com.lpan.java_summarize.enums;

public enum ResultEnum {

    SUCCESS("0000","成功"),
    FAILD("9999","异常"),
    EXISTS("1999","已存在")
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
