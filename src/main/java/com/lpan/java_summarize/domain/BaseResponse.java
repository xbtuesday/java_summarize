package com.lpan.java_summarize.domain;

import lombok.Data;

@Data
public class BaseResponse {

    private String code;
    private String message;
    private Object content;

    public BaseResponse(String code, String message, String content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public BaseResponse() {
    }


}
