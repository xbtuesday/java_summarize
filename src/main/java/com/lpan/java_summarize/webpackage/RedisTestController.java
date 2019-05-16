package com.lpan.java_summarize.webpackage;

import com.lpan.java_summarize.redis.RedisCacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: RedisTestController
 * Description: TODO
 * Author: lpan
 * Date 19-5-16 下午4:53
 * Version: 1.0
 */
@Controller
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisCacheUtils  redisCacheUtils;

    @RequestMapping("/add")
    public void addtest(){
        redisCacheUtils.addString("lpans","1234");
    }

    @RequestMapping("/get")
    public String gettest(){
       String str =  redisCacheUtils.getString("lpan");
        System.out.println(str);
       return str;
    }



}
