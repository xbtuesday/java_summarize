//package com.lpan.java_summarize.common.mybatispluspractise.user.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.lpan.java_summarize.common.mybatispluspractise.user.entity.User;
//import lombok.var;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author lpan
// * @since 2019-05-20
// */
//@RestController
//@RequestMapping("/user")
//public class UserController{
//
//    //@Autowired
//    //private IUserService userService;
//
//    @RequestMapping("/add")
//    public String adduser(){
//        var user = new User();
//        user.setName("liupp");
//        user.setId(1);
//        user.setAge("18");
//        user.setAddress("西安市");
//        user.insert();
//        return "success";
//    }
//
//    @RequestMapping("/list")
//    public String show(){
//        User user = new User();
//        user.setId(1);
//        /**添加查询条件*/
//        QueryWrapper queryWrapper = new QueryWrapper(user);
//        //queryWrapper.allEq()
//        //List<User> list = userService.list(queryWrapper);
//        //return list.toString();
//        return null;
//    }
//
//}
//
