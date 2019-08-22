package com.lpan.java_summarize.common.springdatajpapractise.user.controller;

import com.google.gson.Gson;
import com.lpan.java_summarize.common.springdatajpapractise.user.model.User;
import com.lpan.java_summarize.common.springdatajpapractise.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: UserController
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 06:21
 * Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //@Autowired
    //private ApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    @RequestMapping("/getone")
    public String getone(){
        User user = userService.selectById(1);
        Gson gson = new Gson();

        String s = user.toString();
        return s;
    }

    @RequestMapping("/findbyage")
    public String findbyage(){
        List<User> byAge = userService.findByAge(18);
        Gson gson = new Gson();
        String s1 = gson.toJson(byAge);
        User user = byAge.get(0);
        String s = user.toString();
        return s;
    }

    @RequestMapping("/findbyname/{name}")
    public String findlikename(@PathVariable("name") String name){
        List<User> byAge = userService.findByNameLike(name);
        Gson gson = new Gson();
        String s1 = gson.toJson(byAge);
        //User user = byAge.get(0);
        String s = byAge.toString();
        return s1;
    }

    @RequestMapping("/findByCondition/{name}/{age}/{sex}")
    public String findByCondition(@PathVariable("name") String name,@PathVariable("age") Integer age,@PathVariable("sex") Integer sex){
        List<User> byCondition = userService.findByCondition(name, age, sex);
        Gson gson = new Gson();
        String s = gson.toJson(byCondition);
        return s;
    }


}
