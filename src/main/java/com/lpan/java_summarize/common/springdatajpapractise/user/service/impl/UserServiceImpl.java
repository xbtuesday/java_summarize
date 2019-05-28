package com.lpan.java_summarize.common.springdatajpapractise.user.service.impl;

import com.lpan.java_summarize.common.springdatajpapractise.user.dao.UserRepository;
import com.lpan.java_summarize.common.springdatajpapractise.user.model.User;
import com.lpan.java_summarize.common.springdatajpapractise.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 06:14
 * Version: 1.0
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public int updateById(User user) {
        User user1 = userRepository.saveAndFlush(user);
        int flag = 0;
        if (null !=user1){
            flag = 1;
        }
        return flag;
    }

    @Override
    public User selectById(Integer id) {
        User one = userRepository.getOne(id);
        return one;
    }

    @Override
    public List<User> findByAge(Integer age) {
        List<User> users = userRepository.findByAge(age);
        return users;
    }

    @Override
    public User findByNameLike(String name) {
        User byName = userRepository.findByNameLike(name);
        return byName;
    }
}
