package com.lpan.java_summarize.common.user.controller;


import com.lpan.java_summarize.common.user.entity.User;
import lombok.var;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lpan
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/user")
public class UserController{

    @RequestMapping("/add")
    public String adduser(){
        var user = new User();
        user.setName("liupp");
        user.setId(1);
        user.setAge("18");
        user.setAddress("西安市");
        user.insert();
        return "success";
    }

}

