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

    public static BaseResponse faild(String code,String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse result(ResultEnum resultEnum){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(resultEnum.getCode());
        baseResponse.setMessage(resultEnum.getMessage());
        return baseResponse;
    }
}
