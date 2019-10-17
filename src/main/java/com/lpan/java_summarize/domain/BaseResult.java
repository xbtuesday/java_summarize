package com.lpan.java_summarize.domain;

import com.lpan.java_summarize.enums.ResultEnum;

public class BaseResult {



    public static BaseResponse success(Object object){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ResultEnum.SUCCESS.getCode());
        baseResponse.setMessage(ResultEnum.SUCCESS.getMessage());
        baseResponse.setContent(object);
        return baseResponse;
    }
    public static BaseResponse success(Boolean b){
        BaseResponse baseResponse = new BaseResponse();
        if (b){
            baseResponse.setCode(ResultEnum.SUCCESS.getCode());
            baseResponse.setMessage(ResultEnum.SUCCESS.getMessage());
        }else{
            baseResponse.setCode(ResultEnum.FAILD.getCode());
            baseResponse.setMessage(ResultEnum.FAILD.getMessage());
        }
        return baseResponse;
    }
}
